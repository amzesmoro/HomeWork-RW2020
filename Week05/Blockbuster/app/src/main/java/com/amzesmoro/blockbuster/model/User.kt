package com.amzesmoro.blockbuster.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var username: String? = null,
    var password: String? = null
) : Parcelable