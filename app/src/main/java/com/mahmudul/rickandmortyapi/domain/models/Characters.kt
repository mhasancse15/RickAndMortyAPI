package com.mahmudul.rickandmortyapi.domain.models

data class Characters(
    val info: Info?,
    val results: List<Result>?
)