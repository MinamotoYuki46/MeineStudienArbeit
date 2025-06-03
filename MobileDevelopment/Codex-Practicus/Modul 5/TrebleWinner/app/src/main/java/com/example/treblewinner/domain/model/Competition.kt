package com.example.treblewinner.domain.model


data class Competition (
    val id: String,
    val name: String,
    val country: String,
    val confederation: String,
    val logoUrl: String,
    val logoUrlDark: String
)