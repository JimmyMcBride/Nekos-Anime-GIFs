package com.example.nekosanimegifs.repo

import com.example.nekosanimegifs.models.AnimeCategories
import com.example.nekosanimegifs.models.AnimeGIFList
import com.example.nekosanimegifs.repo.remote.RetrofitInstance
import retrofit2.Response

object NekosRepo {
    suspend fun getAnimeCategoryInfo(): Response<AnimeCategories> {
        return RetrofitInstance.nekosService.getAnimeCategories()
    }
    suspend fun getAnimeGIFURLs(path: String, amount: Int): Response<AnimeGIFList> {
        return RetrofitInstance.nekosService.getAnimeGIFs(path, amount)
    }
}