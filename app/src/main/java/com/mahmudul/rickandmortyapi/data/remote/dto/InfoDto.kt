package com.mahmudul.rickandmortyapi.data.remote.dto

import com.mahmudul.rickandmortyapi.domain.models.Info

data class InfoDto(
    val count: Int?,
    val next: String?,
    val pages: Int?,
    val prev: String?
) {
    fun toInfo(): Info {
        return Info(
            count = count,
            next = next,
            pages = pages,
            prev = prev
        )
    }
}