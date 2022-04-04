package com.example.mvp_mvvm.domain.entities

data class UserProfile(
    val id: String,
    val login: String,
    val email: String,
    val avatarUrl: String,
    val pin: Int
)