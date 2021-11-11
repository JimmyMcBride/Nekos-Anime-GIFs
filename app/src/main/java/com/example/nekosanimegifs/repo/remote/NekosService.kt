package com.example.nekosanimegifs.repo.remote

import com.example.nekosanimegifs.models.AnimeCategories
import com.example.nekosanimegifs.models.AnimeGIFList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NekosService {
    @GET("endpoints")
    suspend fun getAnimeCategories(): Response<AnimeCategories>
    @GET("{category}")
    suspend fun getAnimeGIFs(
        @Path("category") category: String,
        @Query("amount") amount: Int
    ): Response<AnimeGIFList>
}