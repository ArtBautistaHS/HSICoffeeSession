@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hsicoffeeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost

import com.example.hsicoffeeproject.R
import com.example.hsicoffeeproject.components.AppToolBar
import com.example.hsicoffeeproject.components.HeadingTextComponent
import com.example.hsicoffeeproject.navigation.PostOfficeAppRouter
import com.example.hsicoffeeproject.navigation.Screen
import com.example.hsicoffeeproject.ui.theme.GrayColor


@Composable
fun HomeScreen() {
//    Surface(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.White)
//        .padding(28.dp)) {
//        Column(modifier = Modifier.fillMaxSize()){
//            HeadingTextComponent(value = stringResource(id = R.string.home))
//
//        }
//    }
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
            HeadingTextComponent(value = stringResource(id = R.string.home))

        }

    }}
}






@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

