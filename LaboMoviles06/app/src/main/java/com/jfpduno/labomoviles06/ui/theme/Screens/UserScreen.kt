package com.jfpduno.labomoviles06.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.jfpduno.labomoviles06.viewmodel.UserViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    when {

        viewModel.isLoading -> {

            CircularProgressIndicator()
        }

        else -> {

            LazyColumn {

                items(viewModel.users) { user ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = user.idMeal
                            )

                            Text(
                                text = user.strCategory
                            )
                            Text(
                                text = user.strCountry
                            )

                            AsyncImage(
                                model = user.strMealThumb,
                                contentDescription = user.idMeal,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}