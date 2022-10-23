package com.example.shopinglist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shopinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM note_list") //считывает(получать) с базы данных
    fun getAllNote(): Flow<List<NoteItem>>

    @Insert //записыает в базу данных
    suspend fun insertNote(note: NoteItem)
}