package io.markjang.app.mvvm.data.service

import io.markjang.app.mvvm.data.model.RepositoryList
import io.markjang.app.mvvm.data.model.Topics
import kr.co.deliveryhero.test.data.model.Users
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitHubService {

    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    @GET("/search/users")
    suspend fun searchUsers(@Query("q") params: String): Users

    @GET("/search/topics")
    @Headers(
        "Accept: application/vnd.github.mercy-preview+json"
    )
    suspend fun getTopics(@Query("q") params: String): Topics

    @Headers(
        "Accept: application/vnd.github.mercy-preview+json"
    )
    @GET("/search/repositories")
    suspend fun searchRepositories(@Query("q") params: String): RepositoryList

}