package com.github.sigute.tracker.ui.fields

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.github.sigute.tracker.R
import com.github.sigute.tracker.api.model.Field
import com.github.sigute.tracker.api.model.Member
import com.github.sigute.tracker.di.DaggerWrapper
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.activity_search.*
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_fields.*


class FieldsActivity : AppCompatActivity(), FieldsView, OnMapReadyCallback {
    private val presenter by lazy { FieldsPresenter(this, DaggerWrapper(this).component.treckerService) }
    private var map: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fields)

        setUpViews()

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        presenter.retrieveData()
    }

    override fun onMapReady(map: GoogleMap?) {
        this.map = map
        //TODO
    }

    private fun setUpViews() {
        //TODO map
    }

    override fun showLoading() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
            //searchTerm.isEnabled = false
           // searchButton.startLoading()
        }
    }

    override fun showFields(repositories: List<Field>) {
        runOnUiThread {
            //TODO stop loading
            //TODO
        }
    }


    override fun showMembers(repositories: List<Member>) {
        runOnUiThread {
            //TODO stop loading
            //TODO
        }
    }

    override fun showError(error: String) {
        runOnUiThread {
            progressBar.visibility = View.GONE
            //TODO replace this with a nicer way to show errors
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
