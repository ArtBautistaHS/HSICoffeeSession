package com.example.hsicoffeeproject.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hsicoffeeproject.data.home.HomeViewModel
import com.example.hsicoffeeproject.screens.LoginScreen
import com.example.hsicoffeeproject.screens.SignUpScreen
import com.example.hsicoffeeproject.screens.HomeScreen
import com.example.hsicoffeeproject.screens.TermsAndConditionsScreen
import com.example.hsicoffeeproject.navigation.PostOfficeAppRouter
import com.example.hsicoffeeproject.navigation.Screen
import com.example.hsicoffeeproject.screens.MessageScreen
import com.example.hsicoffeeproject.screens.SettingsScreen

@Composable
fun PostOfficeApp(homeViewModel: HomeViewModel = viewModel()){

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){

        if (homeViewModel.isUserLoggedIn.value == true){
            PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen->{
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen ->{
                    TermsAndConditionsScreen()
                }
                is Screen.LoginScreen->{
                    LoginScreen()
                }
                is Screen.HomeScreen ->{
                    HomeScreen()
                }
                is Screen.MessageScreen ->{
                    MessageScreen()
                }
                is Screen.SettingsScreen ->{
                    SettingsScreen()
                }
            }

        }
    }
}