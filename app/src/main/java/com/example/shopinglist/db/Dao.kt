package com.example.shopinglist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.shopinglist.entities.LibraryItem
import com.example.shopinglist.entities.NoteItem
import com.example.shopinglist.entities.ShopListNameItem
import com.example.shopinglist.entities.ShopListItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM note_list") //считывает(получать) с базы данных
    fun getAllNote(): Flow<List<NoteItem>>

    @Query("SELECT * FROM shopping_list_name") //считывает(получать) с базы данных
    fun getAllShopListName(): Flow<List<ShopListNameItem>>

    @Query("SELECT * FROM shop_list_item WHERE listId LIKE :listId") //считывает(получать) с базы данных
    fun getAllShopListItems(listId: Int): Flow<List<ShopListItem>>

    @Query("SELECT * FROM library WHERE name LIKE :name") //получает все элементы из библиотеки
    suspend fun getAllLibraryItems(name: String): List<LibraryItem>

    @Query("DELETE FROM note_list WHERE id IS :id")
    suspend fun deleteNote(id: Int)

    @Query("DELETE FROM shopping_list_name WHERE id IS :id")
    suspend fun deleteShopListName(id: Int)

    @Query("DELETE FROM shop_list_item WHERE listId LIKE :listId") //удаление элиментов из списка
    suspend fun deleteShopItemsByListId(listId: Int)

    @Query("DELETE FROM library WHERE id IS :id")
    suspend fun deleteLibraryItem(id: Int)

    @Insert //записыает в базу данных
    suspend fun insertNote(note: NoteItem)

    @Insert //записыает в базу данных
    suspend fun insertItem(shopListItem: ShopListItem)

    @Insert //записыает в базу данных
    suspend fun insertLibraryItem(libraryItem: LibraryItem)

    @Update //записыает обновленную note в базу данных
    suspend fun updateNote(note: NoteItem)

    @Update // обновляет подсказку в shopList
    suspend fun updateLibraryItem(item: LibraryItem)

    @Update //записыает обновленную shopList в базу данных
    suspend fun updateListName(shopListName: ShopListNameItem)

    @Insert //записыает в базу данных
    suspend fun insertShopListName(name: ShopListNameItem)

    @Update //записыает обновленную shopList в базу данных
    suspend fun updateListItem(item: ShopListItem)
}