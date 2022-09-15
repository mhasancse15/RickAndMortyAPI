package com.mahmudul.rickandmortyapi.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val id: Int?,
    val name: String?,
    val image: String?,
    val location: Location?,
    val origin: Origin?,
    val species: String?,
    val status: String?,
) : Parcelable