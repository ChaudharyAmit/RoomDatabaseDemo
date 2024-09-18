package com.example.roomdatabasedemonew.repository

import com.example.roomdatabasedemonew.room.User
import com.example.roomdatabasedemonew.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class UserRepository(private val userDao: UserDao) {
	suspend fun insert(user: User) {
		withContext(Dispatchers.IO) {
			userDao.insert(user)
		}
	}
	
	suspend fun deleteUser(user: User) {
		withContext(Dispatchers.IO) {
			userDao.deleteUser(user)
		}
	}
	
	suspend fun getAllUsers(): List<User> {
		return withContext(Dispatchers.IO) {
			userDao.getAllUsers()
		}
	}
}
