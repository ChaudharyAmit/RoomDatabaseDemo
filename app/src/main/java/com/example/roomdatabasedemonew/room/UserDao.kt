package com.example.roomdatabasedemonew.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {
	@Insert
	suspend fun insert(user: User)
	
	@Delete
	suspend fun deleteUser(user: User)
	
	@Query("SELECT * FROM users")
	suspend fun getAllUsers(): List<User>
}
