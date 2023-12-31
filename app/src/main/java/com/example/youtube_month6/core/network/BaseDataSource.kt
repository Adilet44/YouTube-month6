package com.example.youtube_month6.core.network

import com.example.youtube_month6.model.PlayLists
import com.example.youtube_month6.result.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()

                if (body != null || response.code() in 200..299) return Resource.success(body)

            } else {
                return Resource.error(response.message(), response.body(), response.code())
            }
        } catch (e: Exception) {
            return Resource.error(e.message ?: e.toString(), null, 429)
        }
        return Resource.error("", null, 429)
    }
}