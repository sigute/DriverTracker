package com.github.sigute.tracker.di

object DaggerWrapper {
    val component: TrackerComponent by lazy {
        DaggerTrackerComponent
                .builder()
                .trackerModule(TrackerModule())
                .build()
    }
}
