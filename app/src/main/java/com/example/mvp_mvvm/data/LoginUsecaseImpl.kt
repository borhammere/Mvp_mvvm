package com.example.mvp_mvvm.data

import android.os.Handler
import androidx.annotation.MainThread
import com.example.mvp_mvvm.domain.LoginApi
import com.example.mvp_mvvm.domain.LoginUsecase

class LoginUsecaseImpl(
    private val api: LoginApi,
    private val uiHandler: Handler
) : LoginUsecase {
    override fun login(
        login: String,
        password: String,
        @MainThread callback: (Boolean) -> Unit
    ) {
        Thread {
            val result = api.login(login, password)
            uiHandler.post {
                callback(result)
            }
        }.start()
    }
}