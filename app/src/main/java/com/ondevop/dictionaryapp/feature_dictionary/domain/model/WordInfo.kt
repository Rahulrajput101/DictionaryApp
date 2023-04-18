package com.ondevop.dictionaryapp.feature_dictionary.domain.model

import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.License
import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.MeaningDto

data class WordInfo(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)
