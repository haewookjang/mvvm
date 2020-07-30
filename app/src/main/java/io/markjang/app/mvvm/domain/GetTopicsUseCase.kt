package io.markjang.app.mvvm.domain

import io.markjang.app.core.di.IoDispatcher
import io.markjang.app.core.domain.usecase.BaseFlowHttpUseCase
import io.markjang.app.mvvm.data.model.Topics
import io.markjang.app.mvvm.data.service.GitHubService
import kotlinx.coroutines.CoroutineDispatcher
import kr.co.deliveryhero.test.data.model.Users
import javax.inject.Inject

class GetTopicsUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val gitHubService: GitHubService
) : BaseFlowHttpUseCase<String, Topics>(dispatcher = dispatcher) {
    override suspend fun execute(parameters: String): Topics {
        return gitHubService.getTopics(parameters)
    }

}