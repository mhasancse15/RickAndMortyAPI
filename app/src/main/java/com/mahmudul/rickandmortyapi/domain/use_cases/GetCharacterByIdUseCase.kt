package com.mahmudul.rickandmortyapi.domain.use_cases

import com.mahmudul.rickandmortyapi.domain.models.ResultById
import com.mahmudul.rickandmortyapi.domain.repository.CharacterRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(id: Int): Single<ResultById> {
        return repository.getCharacterById(id = id)
            .map { it.toResultById() }
            .subscribeOn(Schedulers.io())
    }
}