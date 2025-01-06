package com.example.testapracticodipas.data

import com.example.testapracticodipas.model.GamesModel
import com.example.testapracticodipas.util.Constants.Companion
import com.example.testapracticodipas.util.Constants.Companion.API_KEY
import com.example.testapracticodipas.util.Constants.Companion.ENDPOINT
import com.example.testapracticodipas.util.Constants.Companion.API_KEY2
import com.example.testapracticodipas.util.Constants.Companion.ENDPOINT2
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.GET

interface Apis {

    @GET(ENDPOINT2 + API_KEY2)
    suspend fun getGames(): Response<GamesModel>

}