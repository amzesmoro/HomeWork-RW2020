package com.amzesmoro.blockbuster.data

data class Movie(
    val id: Int?,
    val releaseData: String?,
    val title: String?,
    val summary: String?,
    val poster: Int? = 0,
    val genre: String?,
    val movieDuration: String?,
    val originalLanguage: String?,
    val rating: String?
)