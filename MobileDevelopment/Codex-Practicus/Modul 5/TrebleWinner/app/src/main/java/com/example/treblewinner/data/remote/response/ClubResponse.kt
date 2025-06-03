package com.example.treblewinner.data.remote.response

import com.google.gson.annotations.SerializedName

data class ClubResponse(
    val id: String,
    val name: String,
    val country: String,
    val confederation: String,

    @SerializedName("treble_years")
    val trebleYears: List<String>,

    @SerializedName("competition_ids")
    val competitionIds: List<String>,

    @SerializedName("logo_url")
    val logoUrl: String,

    @SerializedName("web_url")
    val webUrl: String,

    val description: String
)
