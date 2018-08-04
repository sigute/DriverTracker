package com.github.sigute.tracker.ui.search

import com.github.sigute.tracker.api.model.Repository

interface SearchView {
    fun showLoading()
    fun showRepositories(repositories: List<Repository>)
    fun showError(error: String)
}