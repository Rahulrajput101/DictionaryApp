package com.ondevop.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.LicenseDto
import com.ondevop.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.ondevop.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word : String,
    val phonetic: String,
    val license: String,
    val meanings : List<Meaning>,
    @PrimaryKey val id : Int?= null
){
    fun toWordInfo() : WordInfo {
        return WordInfo(
            word =word,
            phonetic = phonetic,
            license = license,
            meanings = meanings
        )
    }


}
