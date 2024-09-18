package com.example.roomdatabasedemonew

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemonew.adapter.UserAdapter
import com.example.roomdatabasedemonew.repository.UserRepository
import com.example.roomdatabasedemonew.room.AppDatabase
import com.example.roomdatabasedemonew.room.User
import com.example.roomdatabasedemonew.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
	private lateinit var userViewModel: UserViewModel
	private lateinit var userAdapter: UserAdapter
	
	@SuppressLint("MissingInflatedId")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		val db = AppDatabase.getDatabase(this)
		val repository = UserRepository(db.userDao())
		userViewModel = ViewModelProvider(this,
			com.example.roomdatabasedemonew.viewmodel.ViewModelFactory(repository)
		).get(UserViewModel::class.java)
		
//		userAdapter = UserAdapter(emptyList(), this)
		userAdapter = UserAdapter(emptyList()) { user ->
			userViewModel.deleteUser(user) // Handle delete when button is clicked
		}
		val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.adapter = userAdapter
		
		userViewModel.loadUsers()
		
		userViewModel.users.observe(this) { users ->
			userAdapter.updateData(users)
		}
		
		findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
			// Example: Adding a new user
			userViewModel.addUser(User(name = "John Doe", age = 30))
		}
		
	}
}
