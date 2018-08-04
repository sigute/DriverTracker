package com.github.sigute.tracker.ui.search

import com.github.sigute.tracker.api.TreckerService
import com.github.sigute.tracker.api.model.SearchRepositoriesResponse
import io.reactivex.observers.ResourceSingleObserver

class SearchPresenter(
        private val searchView: SearchView,
        private val repositoriesDataSource: TreckerService) {

    suspend fun searchTapped(query: String, sortType: SortType) {
        searchView.showLoading()

        repositoriesDataSource.searchRepositories(query, sortType.apiValue)
                .subscribe(object : ResourceSingleObserver<SearchRepositoriesResponse>() {
                    override fun onSuccess(repositoriesResponse: SearchRepositoriesResponse) {
                        val repositories = repositoriesResponse.items
                        if (repositories.isEmpty()) {
                            searchView.showError("No repositories found")
                            return
                        }
                        searchView.showRepositories(repositories)
                    }

                    override fun onError(e: Throwable) {
                        //TODO use error from resources
                        searchView.showError(e.message ?: "error")
                    }
                })
    }
}