package com.mahmudul.rickandmortyapi.domain.repository

import com.mahmudul.rickandmortyapi.data.remote.dto.CharactersDto
import com.mahmudul.rickandmortyapi.data.remote.dto.ResultDto
import io.reactivex.Single

interface CharacterRepository {

    fun getAllCharacters(pageNumber: Int): Single<CharactersDto>

    fun getCharacterById(id: Int): Single<ResultDto>
}