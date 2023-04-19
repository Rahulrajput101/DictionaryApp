package com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto

import com.ondevop.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity
import com.ondevop.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
)


fun WordInfoDto.toWordInfoEntity() : WordInfoEntity{
    return WordInfoEntity(
        license = license.name,
        meanings = meanings.map { it.toMeaning() },
        phonetic = phonetic,
        word =word

    )
}