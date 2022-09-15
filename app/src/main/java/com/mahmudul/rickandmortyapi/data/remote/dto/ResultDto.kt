package com.mahmudul.rickandmortyapi.data.remote.dto

import com.mahmudul.rickandmortyapi.domain.models.Result
import com.mahmudul.rickandmortyapi.domain.models.ResultById

data class ResultDto(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: LocationDto?,
    val name: String?,
    val origin: OriginDto?,
    val species: String?,
    val status: String?,
    val type: String?,
    val url: String?
) {
    fun toResult(): Result {
        return com.mahmudul.rickandmortyapi.domain.models.Result(
            id = id,
            image = image,
            location = location?.toLocation(),
            name = name,
            species = species,
            status = status,
            origin = origin?.toOrigin()
        )
    }

    fun toResultById(): ResultById {
        return ResultById(
            id = id,
            image = image,
            name = name,
            species = species,
            status = status,
            gender = gender,
            origin = origin?.toOrigin(),
            location = location?.toLocation(),
            type = type,
            episode = episode,
        )
    }
}