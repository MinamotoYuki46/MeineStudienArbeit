package com.example.treblewinner.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club (
    val name: String,
    val country: String,
    val confederation: String,
    val trebleYears: List<String>,
    val competitions: List<Competition>,
    val logoUrl: String,
    val webUrl: String,
    val description: String
): Parcelable