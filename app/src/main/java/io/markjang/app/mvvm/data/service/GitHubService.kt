package io.markjang.app.mvvm.data.service

import kr.co.deliveryhero.test.data.model.Users
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {

    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    @GET("/search/users")
    suspend fun searchUsers(@Query("q") params: String): Users
}