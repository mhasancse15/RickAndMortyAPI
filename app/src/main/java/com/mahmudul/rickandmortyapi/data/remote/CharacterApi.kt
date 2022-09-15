package com.mahmudul.rickandmortyapi.data.remote

import com.mahmudul.rickandmortyapi.data.remote.dto.CharactersDto
import com.mahmudul.rickandmortyapi.data.remote.dto.ResultDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    fun getAllCharacters(
        @Query("page") pageNumber: Int?
    ): Single<CharactersDto>

    @GET("character/{id}")
    fun getCharacterById(
        @Path("id") id: Int
    ): Single<ResultDto>
}