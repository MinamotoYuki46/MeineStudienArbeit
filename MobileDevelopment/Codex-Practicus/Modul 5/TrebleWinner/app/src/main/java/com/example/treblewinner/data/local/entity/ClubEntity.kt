package com.example.treblewinner.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs")
data class ClubEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "confederation")
    val confederation: String,

    @ColumnInfo(name = "treble_years")
    val trebleYears: List<String>,

    @ColumnInfo(name = "competition_ids")
    val competitionIds: List<String>,

    @ColumnInfo(name = "logo_url")
    val logoUrl: String,

    @ColumnInfo(name = "web_url")
    val webUrl: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "is_bookmarked")
    val isBookmarked: Boolean = false
)
