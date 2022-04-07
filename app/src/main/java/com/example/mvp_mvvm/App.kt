package com.example.mvp_mvvm

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.mvp_mvvm.data.LoginUsecaseImpl
import com.example.mvp_mvvm.data.api.MockLoginApiImpl
import com.example.mvp_mvvm.domain.LoginApi
import com.example.mvp_mvvm.domain.LoginUsecase

class App : Application() {
    private val loginApi: LoginApi by lazy { MockLoginApiImpl() }
    val loginUsecase: LoginUsecase by lazy {
        LoginUsecaseImpl(app.loginApi, Handler(Looper.getMainLooper()))
    }

}

val Context.app: App
    get() {
        return applicationContext as App
    }