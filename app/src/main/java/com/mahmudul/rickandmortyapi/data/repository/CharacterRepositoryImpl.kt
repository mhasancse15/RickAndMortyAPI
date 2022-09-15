package com.mahmudul.rickandmortyapi.data.repository

import com.mahmudul.rickandmortyapi.data.remote.CharacterApi
import com.mahmudul.rickandmortyapi.data.remote.dto.CharactersDto
import com.mahmudul.rickandmortyapi.data.remote.dto.ResultDto
import com.mahmudul.rickandmortyapi.domain.repository.CharacterRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterApi: CharacterApi
) : CharacterRepository {

    override fun getAllCharacters(pageNumber: Int): Single<CharactersDto> {
        return characterApi.getAllCharacters(pageNumber)
            .subscribeOn(Schedulers.io())
    }

    override fun getCharacterById(id: Int): Single<ResultDto> {
        return characterApi.getCharacterById(id = id)
            .subscribeOn(Schedulers.io())
    }

}
