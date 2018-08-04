package com.github.sigute.tracker.ui.repositories

import com.github.sigute.tracker.api.model.Repository

interface RepositoriesView {
    fun showRepositories(repositories: List<Repository>)
    fun showRepository(repository: Repository)
}