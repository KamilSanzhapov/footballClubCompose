package ru.typedeff.footballclub.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.typedeff.footballclub.data.db.dao.FavoriteDao
import ru.typedeff.footballclub.data.db.entities.FavoriteCompetitionEntity

@Database(entities = [FavoriteCompetitionEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getFavoriteDao(): FavoriteDao
}




