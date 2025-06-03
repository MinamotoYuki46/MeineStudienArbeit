package com.example.treblewinner.data.remote.response

import com.google.gson.annotations.SerializedName

data class CompetitionResponse(
    val id: String,
    val name: String,
    val country: String,
    val confederation: String,

    @SerializedName("logo_url")
    val logoUrl: String,

    @SerializedName("logo_url_dark")
    val logoUrlDark: String
)
