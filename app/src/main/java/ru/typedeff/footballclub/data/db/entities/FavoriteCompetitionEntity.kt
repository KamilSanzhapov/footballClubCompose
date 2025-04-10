package ru.typedeff.footballclub.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavoriteCompetitionEntity(
    @PrimaryKey val id: Int,
    val name: String? = null,
    val code: String? = null,
    val type: String? = null,
    val emblem: String? = null
)