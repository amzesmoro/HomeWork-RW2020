package com.amzesmoro.blockbuster.data

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id: Int?,
    val releaseDate: String?,
    val title: String?,
    val summary: String?,
    val poster: Int? = 0,
    val backdropPoster: Int? = 0,
    val genre: String?,
    val movieDuration: String?,
    val originalLanguage: String?,
    val rating: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(releaseDate)
        parcel.writeString(title)
        parcel.writeString(summary)
        parcel.writeValue(poster)
        parcel.writeValue(backdropPoster)
        parcel.writeString(genre)
        parcel.writeString(movieDuration)
        parcel.writeString(originalLanguage)
        parcel.writeString(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}