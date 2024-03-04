package com.example.hsicoffeeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hsicoffeeproject.R
import com.example.hsicoffeeproject.components.AppToolBar
import com.example.hsicoffeeproject.components.ButtonComponent
import com.example.hsicoffeeproject.components.HeadingTextComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen() {
    Scaffold(
        bottomBar = {
            AppToolBar()
        }
    ){paddingValues -> Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = stringResource(id = R.string.messages))

        }

    }}
}
@Preview
@Composable
fun MessageScreenPreview() {
    MessageScreen()
}

