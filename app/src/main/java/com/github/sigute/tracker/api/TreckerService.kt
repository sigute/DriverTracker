package com.github.sigute.tracker.api

import com.github.sigute.tracker.api.model.AuthResponse
import com.github.sigute.tracker.api.model.Member
import com.github.sigute.tracker.api.model.SearchRepositoriesResponse
import io.reactivex.Single
import retrofit2.http.*

interface TreckerService {
    @GET("/api/v3/search/repositories")
    fun searchRepositories(
            @Query("q") query: String,
            @Query("sort") sort: String?,
            @Query("order") order: String = "desc")
            : Single<SearchRepositoriesResponse>

    @FormUrlEncoded
    @POST("/api/v3/auth/session")
    fun getAuthSession(
            @Field("email") email: String,
            @Field("password") password: String
    ): Single<AuthResponse>

    @GET("/api/v3/fields")
    fun getFields(): Single<List<com.github.sigute.tracker.api.model.Field>>

    @GET("/api/v3/members")
    fun getMembers(): Single<List<Member>>
}
