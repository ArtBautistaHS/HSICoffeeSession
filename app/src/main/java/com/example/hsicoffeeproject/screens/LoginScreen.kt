package com.example.hsicoffeeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hsicoffeeproject.R
import com.example.hsicoffeeproject.components.ButtonComponent
import com.example.hsicoffeeproject.components.ClickableLoginTextComponent
import com.example.hsicoffeeproject.components.DividerTextComponent
import com.example.hsicoffeeproject.components.HeadingTextComponent
import com.example.hsicoffeeproject.components.MyTextFieldComponent
import com.example.hsicoffeeproject.components.NormalTextComponent
import com.example.hsicoffeeproject.components.PasswordTextFieldComponent
import com.example.hsicoffeeproject.components.UnderLinedNormalTextComponent
import com.example.hsicoffeeproject.data.login.LoginUIEvent
import com.example.hsicoffeeproject.data.login.LoginViewModel
import com.example.hsicoffeeproject.navigation.PostOfficeAppRouter
import com.example.hsicoffeeproject.navigation.Screen
import com.example.hsicoffeeproject.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {


        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))

                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.ic_email),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },  errorStatus = loginViewModel.loginUIState.value.emailError
                )

                Spacer(modifier = Modifier.height(10.dp))

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.ic_password),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    }, errorStatus = loginViewModel.loginUIState.value.passwordError
                )
                Spacer(modifier = Modifier.height(40.dp))

                UnderLinedNormalTextComponent(value = stringResource(R.string.forgot_your_password))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
                })


            }
        }
        if(loginViewModel.loginInProgress.value){
            CircularProgressIndicator()
        }
    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}