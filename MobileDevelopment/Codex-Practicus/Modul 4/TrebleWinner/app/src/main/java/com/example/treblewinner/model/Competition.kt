package com.example.treblewinner.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Competition (
    val name: String,
    val country: String,
    val confederation: String,
    val logoUrl: String,
    val logoUrlDark: String
): Parcelable