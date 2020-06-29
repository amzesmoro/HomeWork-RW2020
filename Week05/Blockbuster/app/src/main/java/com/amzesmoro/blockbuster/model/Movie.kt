package com.amzesmoro.blockbuster.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey val id: Int,
    val releaseDate: String,
    val title: String,
    val summary: String,
    val poster: Int = 0,
    val backdropPoster: Int = 0,
    val genre: String,
    val movieDuration: String,
    val originalLanguage: String,
    val rating: String
) : Parcelable