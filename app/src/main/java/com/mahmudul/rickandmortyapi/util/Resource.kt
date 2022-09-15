package com.mahmudul.rickandmortyapi.util

import okhttp3.ResponseBody

data class
Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val isNetworkError: Boolean? = null,
    val errorCode: Int? = null,
    val errorBody: ResponseBody? = null) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error( message: String, isNetworkError: Boolean? = null, errorCode: Int? = null, errorBody: ResponseBody? = null, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message, isNetworkError, errorCode, errorBody)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null, )
        }
    }



}