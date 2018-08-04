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
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_fields.*


class FieldsActivity : AppCompatActivity(), FieldsView, OnMapReadyCallback {
    private val presenter by lazy {
        FieldsPresenter(
                this,
                DaggerWrapper(this).component.treckerService,
                DaggerWrapper(this).component.authPreferences,
                getString(R.string.username),
                getString(R.string.password))
    }
    private var map: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fields)

        setUpViews()
        presenter.retrieveData()
    }

    private fun setUpViews() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        this.map = map
        //TODO
    }

    override fun startLoading() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }
    }

    override fun stopLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showFields(repositories: List<Field>) {
        runOnUiThread {
            //TODO
        }
    }


    override fun showMembers(repositories: List<Member>) {
        runOnUiThread {
            //TODO
        }
    }

    override fun showError(error: String) {
        runOnUiThread {
            //TODO replace this with a nicer way to show errors
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
