package com.github.sigute.tracker.di

import android.content.Context

object DaggerWrapper(val context: Context) {
    val component: TrackerComponent by lazy {
        DaggerTrackerComponent
                .builder()
                .trackerModule(TrackerModule(context))
                .build()
    }
}
