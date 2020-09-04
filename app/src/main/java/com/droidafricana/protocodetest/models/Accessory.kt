package com.droidafricana.protocodetest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Accessory(
    val smallMeko: Int?,
    val bigMeko: Int?,
    val cooker: Int?,
    val regulator: Int?
) : Parcelable