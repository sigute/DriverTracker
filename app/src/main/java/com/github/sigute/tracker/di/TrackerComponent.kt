package com.github.sigute.tracker.di

import com.github.sigute.tracker.api.GithubService

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [(TrackerModule::class)])
interface TrackerComponent {
    val githubService: GithubService
}
