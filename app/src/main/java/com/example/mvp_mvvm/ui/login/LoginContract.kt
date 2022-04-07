package com.example.mvp_mvvm.ui.login

import androidx.annotation.MainThread
import com.example.mvp_mvvm.utils.Publisher

interface LoginContract {

    /**
     * MVP  - Model View Presenter
     * 1) Восстановление состояния
     * 2) Большая* связность
     * 3) Многословность - проверки на нулл, постоянные вызовы вью
     *
     * (M) <- (P) <-> (V)
     *
     * MVVM - Model View ViewModel
     * (M) <- (VM) <- (V)
     */

//    Интерфейс вью больше не нужен в MVVM
//    Её роль достаётся подпискам во ViewModel

//    interface View {
//        @MainThread
//        fun setSuccess() // isSuccess
//
//        @MainThread
//        fun setError(error: String)
//
//        @MainThread
//        fun showProgress() // shouldShowProgress
//
//        @MainThread
//        fun hideProgress() // shouldShowProgress
//    }


    /**
     * class Activity {
     *
     *  fun onCreate() {
     *      viewModel.shouldShowProgress.subscribe { it ->
     *          if (it) {
     *              dialog.show()
     *          } else {
     *              dialog.dismiss()
     *          }
     *      }
     *  }
     *
     * }
     */

    interface ViewModel {
        val shouldShowProgress: Publisher<Boolean>
        val isSuccess: Publisher<Boolean>
        val errorText: Publisher<String?>

        @MainThread
        fun onLogin(login: String, password: String)

        @MainThread
        fun onCredentialsChanged()
    }
}