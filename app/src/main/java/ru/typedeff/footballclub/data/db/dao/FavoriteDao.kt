package ru.typedeff.footballclub.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete

import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import ru.typedeff.footballclub.data.db.entities.FavoriteCompetitionEntity

@Dao
interface FavoriteDao {
    @Query("Select * from favoritecompetitionentity")
    suspend fun getAll(): List<FavoriteCompetitionEntity>

    @Query("Select id from favoritecompetitionentity")
    suspend fun getAllIds(): List<Int>

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: FavoriteCompetitionEntity)

    @Query("Select * from favoritecompetitionentity where id  = :id")
    suspend fun getById(id:String):  List<FavoriteCompetitionEntity>

    @Delete
    suspend fun delete(entity: FavoriteCompetitionEntity)
}