package com.ondevop.dictionaryapp.feature_dictionary.data.repository

import androidx.compose.ui.tooling.data.EmptyGroup.data
import com.ondevop.dictionaryapp.core.util.Resource
import com.ondevop.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.ondevop.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.toWordInfo
import com.ondevop.dictionaryapp.feature_dictionary.data.remote.dto.toWordInfoEntity
import com.ondevop.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.ondevop.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.NonCancellable.message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImp (
    val api: DictionaryApi,
    val dao: WordInfoDao
        ): WordInfoRepository {
    override fun getWordInfo(word : String): Flow<Resource<List<WordInfo>>>  = flow {
        emit(Resource.Loading())
        val wordInfo = dao.getWordInfo(word).map {it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))

        try{
            val remoteWordInfo = api.getWordInfo(word)
            dao.deleteWordInfo(remoteWordInfo.map { it.word })
            dao.insertWordInfo(remoteWordInfo.map { it.toWordInfoEntity() })

        }catch (e : HttpException){
           emit(  Resource.Error(
                message = "Oops, Something went wrong",
                data = wordInfo
            ))
        }catch ( e : IOException){
           emit( Resource.Error(
                message = "Couldn't reach server, check your internet",
                data = wordInfo
            ))
        }

        val newWordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
            emit(Resource.Success(newWordInfo))

    }


}