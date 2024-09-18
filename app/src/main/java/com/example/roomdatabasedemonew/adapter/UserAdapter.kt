package com.example.roomdatabasedemonew.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemonew.R
import com.example.roomdatabasedemonew.room.User


class UserAdapter(private var users: List<User>, private val onDelete: (User) -> Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
	
	class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val userName: TextView = view.findViewById(R.id.userName)
		val userAge: TextView = view.findViewById(R.id.userAge)
		val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
		return UserViewHolder(view)
	}
	
	override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
		val user = users[position]
		holder.userName.text = user.name
		holder.userAge.text = user.age.toString()
		holder.deleteButton.setOnClickListener {
			onDelete(user) // Trigger the delete action
		}
	}
	
	override fun getItemCount(): Int = users.size
	
	fun updateData(newUsers: List<User>) {
		users = newUsers
		notifyDataSetChanged()
	}
}
