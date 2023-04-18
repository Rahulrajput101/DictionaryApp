package com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto

import com.ondevop.dictionaryapp.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)

fun DefinitionDto.toDefinition() :Definition{
    return  Definition(
        antonyms =antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms
    )
}
