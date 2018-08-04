package com.github.sigute.tracker.ui.fields

import com.github.sigute.tracker.api.TreckerService
import com.github.sigute.tracker.api.model.AuthResponse
import com.github.sigute.tracker.api.model.Field
import com.github.sigute.tracker.api.model.Member
import com.github.sigute.tracker.utils.AuthPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.ResourceSingleObserver
import io.reactivex.schedulers.Schedulers

class FieldsPresenter(
        private val view: FieldsView,
        private val service: TreckerService,
        private val authPreferences: AuthPreferences,
        private val username: String,
        private val password: String) {
    private var fields: List<Field> = ArrayList()
    private var members: List<Member> = ArrayList()
    private var fieldsRetrieved = false
    private var membersRetrieved = false

    fun retrieveData() {
        view.startLoading()
        fieldsRetrieved = false
        membersRetrieved = false

        if (authPreferences.token != null) {
            retrieveFieldsAndMembers()
        } else {
            carryOutAuth()
        }
    }

    //TODO auth should be carried out in a new login activity, allowing user to provide credentials themselves
    private fun carryOutAuth() {
        service.getAuthSession(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ResourceSingleObserver<AuthResponse>() {
                    override fun onSuccess(authResponse: AuthResponse) {
                        authPreferences.token = authResponse.token
                        retrieveFieldsAndMembers()
                    }

                    override fun onError(e: Throwable) {
                        showError(e)
                    }
                })
    }

    private fun retrieveFieldsAndMembers() {
        retrieveFields()
        retrieveMembers()
    }

    private fun retrieveFields() {
        service.getFields()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ResourceSingleObserver<List<Field>>() {
                    override fun onSuccess(fieldsResponse: List<Field>) {
                        fields = fieldsResponse
                        fieldsRetrieved = true
                        view.showFields(fields)
                        stopLoading()
                    }

                    override fun onError(e: Throwable) {
                        showError(e)
                    }
                })
    }

    private fun retrieveMembers() {
        service.getMembers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : ResourceSingleObserver<List<Member>>() {
                    override fun onSuccess(membersResponse: List<Member>) {
                        members = membersResponse
                        membersRetrieved = true
                        view.showMembers(members)
                        stopLoading()
                    }

                    override fun onError(e: Throwable) {
                        showError(e)
                    }
                })
    }

    private fun stopLoading() {
        if (fieldsRetrieved && membersRetrieved) {
            view.stopLoading()
        }
    }

    private fun showError(e: Throwable) {
        //TODO in case of auth error, re-authentication might be required
        //TODO use error from resources
        view.showError(e.message ?: "error")
    }
}