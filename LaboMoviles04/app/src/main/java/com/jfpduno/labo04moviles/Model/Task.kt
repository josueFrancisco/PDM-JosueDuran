package com.jfpduno.labo04moviles.Model

import java.util.Date

class Task {
    data class Task (
        val id: Int,
        val title: String,
        val description: String,
        val endDate: Date = Date(),
        val isCompleted: Boolean = false
    )

}


