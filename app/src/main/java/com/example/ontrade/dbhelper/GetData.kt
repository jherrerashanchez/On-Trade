package com.example.ontrade.dbhelper

import io.reactivex.Observable
import retrofit2.http.GET

interface GetData {
    @GET(".")
    fun getData() : Observable<List<String>>
}