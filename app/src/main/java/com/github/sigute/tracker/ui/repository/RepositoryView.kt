package com.github.sigute.tracker.ui.repository

import com.github.sigute.tracker.api.model.Repository

interface RepositoryView {
    fun showRepository(repository: Repository)
}