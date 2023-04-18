package com.ondevop.dictionaryapp.feature_dictionary.data.remote

import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.WordInfoDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {


    @GET("/api/v2/entries/en/{word}")
    fun getWordInfo(
        @Path("word") word : String
    ) : WordInfoDto




}