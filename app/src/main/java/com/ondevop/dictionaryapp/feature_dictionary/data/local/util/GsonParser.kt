package com.ondevop.dictionaryapp.feature_dictionary.data.local.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

class GsonParser(
    val gson: Gson
) : JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json,type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj,type)
    }
}