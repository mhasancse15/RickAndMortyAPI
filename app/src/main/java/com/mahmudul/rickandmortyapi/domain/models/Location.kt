package com.mahmudul.rickandmortyapi.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val name: String?,
    val url: String?
) : Parcelable