package com.mahmudul.rickandmortyapi.data.remote.dto

import com.mahmudul.rickandmortyapi.domain.models.Characters


data class CharactersDto(
    val info: InfoDto?,
    val results: List<ResultDto>?
) {
    fun toCharacter(): Characters {
        return Characters(
            info = info?.toInfo(),
            results = results?.map { it.toResult() }
        )
    }
}