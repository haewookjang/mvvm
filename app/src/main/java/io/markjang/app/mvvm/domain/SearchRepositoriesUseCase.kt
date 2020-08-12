package io.markjang.app.mvvm.domain

import io.markjang.app.core.di.IoDispatcher
import io.markjang.app.core.domain.usecase.BaseFlowHttpUseCase
import io.markjang.app.mvvm.data.model.RepositoryList
import io.markjang.app.mvvm.data.service.GitHubService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SearchRepositoriesUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val gitHubService: GitHubService
) :
    BaseFlowHttpUseCase<String, RepositoryList>(coroutineDispatcher) {
    override suspend fun execute(parameters: String): RepositoryList {
        return gitHubService.searchRepositories(parameters)
    }
}