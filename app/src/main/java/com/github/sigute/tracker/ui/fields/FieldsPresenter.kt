package com.github.sigute.tracker.ui.fields

import com.github.sigute.tracker.api.TreckerService
import com.github.sigute.tracker.api.model.SearchRepositoriesResponse
import com.github.sigute.tracker.ui.search.SortType
import io.reactivex.observers.ResourceSingleObserver

class FieldsPresenter(
        private val view: FieldsView,
        private val service: TreckerService) {

    fun retrieveData() {
        view.showLoading()

        //TODO auth
        //TODO get fields and members
//        service.searchRepositories(query, sortType.apiValue)
//                .subscribe(object : ResourceSingleObserver<SearchRepositoriesResponse>() {
//                    override fun onSuccess(repositoriesResponse: SearchRepositoriesResponse) {
//                        val repositories = repositoriesResponse.items
//                        if (repositories.isEmpty()) {
//                            view.showError("No repositories found")
//                            return
//                        }
//                        view.showFields(repositories)
//                    }
//
//                    override fun onError(e: Throwable) {
//                        //TODO use error from resources
//                        view.showError(e.message ?: "error")
//                    }
//                })
    }
}