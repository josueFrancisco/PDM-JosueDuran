package com.jfpduno.labo04moviles.ViewModel

import androidx.lifecycle.ViewModel
import com.jfpduno.labo04moviles.Model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel {
    class GeneralViewModel : ViewModel() {
        private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
        val tasks = _tasks.asStateFlow()

        fun addTask(task: Task) {
            _tasks.value = _tasks.value.toMutableList().apply { add(task) }
        }
    }
}


