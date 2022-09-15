package com.mahmudul.rickandmortyapi.data.remote.dto

import com.mahmudul.rickandmortyapi.domain.models.Location

data class LocationDto(
    val name: String?,
    val url: String?
) {
    fun toLocation(): Location {
        return Location(
            name = name,
            url = url
        )
    }
}