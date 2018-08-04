package com.github.sigute.tracker.ui.fields

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.github.sigute.tracker.R
import com.github.sigute.tracker.api.model.Field
import com.github.sigute.tracker.api.model.Member
import com.github.sigute.tracker.di.DaggerWrapper
import kotlinx.android.synthetic.main.activity_search.*

class FieldsActivity : AppCompatActivity(), FieldsView {
    private val presenter by lazy { FieldsPresenter(this, DaggerWrapper(this).component.treckerService) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setUpViews()
        presenter.retrieveData()
    }

    override fun onStop() {
        super.onStop()
        searchButton.reset()
    }

    private fun setUpViews() {
        //TODO map
    }

    override fun showLoading() {
        runOnUiThread {
            searchTerm.isEnabled = false
            searchButton.startLoading()
        }
    }

    override fun showFields(repositories: List<Field>) {
        runOnUiThread {
            searchButton.loadingSuccessful()
            searchTerm.isEnabled = true
            //TODO
        }
    }


    override fun showMembers(repositories: List<Member>) {
        runOnUiThread {
            searchButton.loadingSuccessful()
            searchTerm.isEnabled = true
            //TODO
        }
    }

    override fun showError(error: String) {
        runOnUiThread {
            searchTerm.isEnabled = true
            searchButton.loadingFailed()
            //TODO replace this with a nicer way to show errors
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
