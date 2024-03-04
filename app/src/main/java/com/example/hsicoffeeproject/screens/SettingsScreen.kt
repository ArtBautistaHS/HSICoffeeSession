package com.example.hsicoffeeproject.screens

import android.content.ContentValues.TAG
import android.util.Log
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
import androidx.compose.ui.unit.dp
import com.example.hsicoffeeproject.R
import com.example.hsicoffeeproject.components.AppToolBar
import com.example.hsicoffeeproject.components.ButtonComponent
import com.example.hsicoffeeproject.components.HeadingTextComponent
import com.example.hsicoffeeproject.navigation.PostOfficeAppRouter
import com.example.hsicoffeeproject.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
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
            HeadingTextComponent(value = stringResource(id = R.string.settings))

        }

    }}
}



fun logout() {

    val firebaseAuth = FirebaseAuth.getInstance()

    firebaseAuth.signOut()

    val authStateListener = FirebaseAuth.AuthStateListener {
        if (it.currentUser == null) {
            Log.d(TAG, "Inside sign outsuccess")
            PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
        } else {
            Log.d(TAG, "Inside sign out is not complete")
        }
    }

    firebaseAuth.addAuthStateListener(authStateListener)

}