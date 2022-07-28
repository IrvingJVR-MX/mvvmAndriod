package com.example.mvvm.network

import com.example.mvvm.models.RecyclerList
import retrofit2.http.GET


interface RetroService {
    @GET ("posts")
    suspend fun getDataFromApiJson(): ArrayList<RecyclerList>

}