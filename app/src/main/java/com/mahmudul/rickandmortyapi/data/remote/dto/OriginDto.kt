package com.mahmudul.rickandmortyapi.data.remote.dto

import com.mahmudul.rickandmortyapi.domain.models.Origin

data class OriginDto(
    val name: String?,
    val url: String?
) {
    fun toOrigin(): Origin {
        return Origin(
            name = name,
            url = url
        )
    }
}

