package com.github.sigute.tracker.di

import com.github.sigute.tracker.api.TreckerService
import com.github.sigute.tracker.utils.AuthPreferences

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [(TrackerModule::class)])
interface TrackerComponent {
    val treckerService: TreckerService
    val authPreferences: AuthPreferences
}
