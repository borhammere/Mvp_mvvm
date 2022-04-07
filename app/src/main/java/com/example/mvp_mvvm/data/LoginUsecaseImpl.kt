package com.example.mvp_mvvm.data

import androidx.annotation.MainThread
import com.example.mvp_mvvm.domain.LoginApi
import com.example.mvp_mvvm.domain.LoginUsecase

class LoginUsecaseImpl(
    private val api: LoginApi
) : LoginUsecase {
    override fun login(
        login: String,
        password: String,
        @MainThread callback: (Boolean) -> Unit
    ) {
        Thread {
            val result = api.login(login, password)
            callback(result)
        }.start()
    }
}