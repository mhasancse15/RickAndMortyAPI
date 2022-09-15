package com.mahmudul.rickandmortyapi.domain.models

data class ResultById(
    val id: Int?,
    val image: String?,
    val name: String?,
    val species: String?,
    val status: String?,
    val gender: String?,
    val origin: Origin?,
    val location: Location?,
    val type: String?,
    val episode: List<String>?
)