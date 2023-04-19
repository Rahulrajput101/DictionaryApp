package com.ondevop.dictionaryapp.feature_dictionary.domain.model

import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.LicenseDto

data class WordInfo(
    val license: String,
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
)
