package com.github.sigute.tracker.ui.fields

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.github.sigute.tracker.R
import com.github.sigute.tracker.api.model.Field
import com.github.sigute.tracker.api.model.Member
import com.github.sigute.tracker.di.DaggerWrapper
import com.github.sigute.tracker.utils.getRandomRainbowColor
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions
import com.google.maps.android.PolyUtil
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

        startLoading()
        setUpViews()
    }

    //TODO add support for screen rotation

    private fun setUpViews() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        this.map = map
        presenter.retrieveData()
    }

    override fun startLoading() {
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }
    }

    override fun stopLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showFields(fields: List<Field>) {
        runOnUiThread {
            map?.let { map ->
                val bounds = LatLngBounds.builder()

                fields.forEach { field ->
                    val polylineValues = PolyUtil.decode(field.polyline)
                    val polygonOptions = PolygonOptions()
                            .addAll(polylineValues)
                            .fillColor(getRandomRainbowColor(this, 0.2f))
                    map.addPolygon(polygonOptions)

                    polylineValues.forEach { bounds.include(it) }
                }

                //TODO this helps with finding fields, but it's still unclear from this zoom level where most of them are
                map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 0))

            }
        }
    }

    override fun showMembers(members: List<Member>) {
        runOnUiThread {
            map?.let { map ->
                members.forEach { member ->
                    val markerOptions = MarkerOptions()
                    markerOptions.position(LatLng(member.lastKnownPosition.latitude, member.lastKnownPosition.longitude))
                    map.addMarker(markerOptions)
                }
            }
        }
    }

    override fun showError(error: String) {
        runOnUiThread {
            //TODO replace this with a nicer way to show errors
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
