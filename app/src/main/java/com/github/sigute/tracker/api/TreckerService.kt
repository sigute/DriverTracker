package com.github.sigute.tracker.api

import com.github.sigute.tracker.api.model.AuthResponse
import com.github.sigute.tracker.api.model.Member
import com.github.sigute.tracker.api.model.SearchRepositoriesResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TreckerService {
    @GET("/search/repositories")
    fun searchRepositories(
            @Query("q") query: String,
            @Query("sort") sort: String?,
            @Query("order") order: String = "desc")
            : Single<SearchRepositoriesResponse>

    @POST("/auth/session")
    fun getAuthSession(
            @Field("email") email: String,
            @Field("password") password: String
    ): Single<AuthResponse>

    @GET("/fields")
    fun getFields(): Single<List<com.github.sigute.tracker.api.model.Field>>

    @GET("/members")
    fun getMembers(): Single<List<Member>>
}
