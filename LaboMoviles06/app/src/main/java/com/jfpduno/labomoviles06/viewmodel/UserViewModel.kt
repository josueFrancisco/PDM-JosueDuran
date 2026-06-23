package com.jfpduno.labomoviles06.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfpduno.labomoviles06.data.remote.RetrofitInstance
import com.jfpduno.labomoviles06.model.Meal
import com.jfpduno.labomoviles06.model.Meals
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    var users by mutableStateOf<List<Meal>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadUsers() {

        viewModelScope.launch {

            isLoading = true

            try {
                Log.d("Status","Vivo")

                users = RetrofitInstance
                    .api
                    .getUsers().meals

                Log.d("Status",users.toString())

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                isLoading = false
            }
        }
    }
}