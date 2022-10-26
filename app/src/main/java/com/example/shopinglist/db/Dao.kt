package com.example.shopinglist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.shopinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM note_list") //считывает(получать) с базы данных
    fun getAllNote(): Flow<List<NoteItem>>

    @Query("DELETE FROM note_list WHERE id IS :id")
    suspend fun deleteNote(id: Int)

    @Insert //записыает в базу данных
    suspend fun insertNote(note: NoteItem)

    @Update //записыает обновленную note в базу данных
    suspend fun updateNote(note: NoteItem)
}