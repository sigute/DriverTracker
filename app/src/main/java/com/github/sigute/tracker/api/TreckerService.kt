package com.github.sigute.tracker.api

import com.github.sigute.tracker.api.model.AuthResponse
import com.github.sigute.tracker.api.model.Member
import io.reactivex.Single
import retrofit2.http.*

interface TreckerService {
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
