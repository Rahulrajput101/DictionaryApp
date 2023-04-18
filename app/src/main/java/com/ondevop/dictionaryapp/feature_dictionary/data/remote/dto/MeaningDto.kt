package com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto

import com.ondevop.dictionaryapp.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val antonyms: List<String>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<Any>
)

fun MeaningDto.toMeaning() : Meaning{
    return Meaning(
        definitions = definitions.map { it.toDefinition() },
        partOfSpeech = partOfSpeech
    )
}