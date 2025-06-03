package com.example.treblewinner.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competitions")
data class CompetitionEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "confederation")
    val confederation: String,

    @ColumnInfo(name = "logo_url")
    val logoUrl: String,

    @ColumnInfo(name = "logo_url_dark")
    val logoUrlDark: String
)
