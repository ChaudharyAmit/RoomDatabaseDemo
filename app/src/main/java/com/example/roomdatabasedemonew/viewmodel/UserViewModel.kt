package com.example.roomdatabasedemonew.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasedemonew.repository.UserRepository
import com.example.roomdatabasedemonew.room.User
import kotlinx.coroutines.launch


class UserViewModel(private val repository: UserRepository) : ViewModel() {
	private val _users = MutableLiveData<List<User>>()
	val users: LiveData<List<User>> get() = _users
	
	fun addUser(user: User) {
		viewModelScope.launch {
			repository.insert(user)
			loadUsers() // Refresh the list after adding
		}
	}
	
	fun loadUsers() {
		viewModelScope.launch {
			_users.value = repository.getAllUsers()
		}
	}
	
	fun deleteUser(user: User) {
		viewModelScope.launch {
			repository.deleteUser(user)
			loadUsers()
		}
	}
}
