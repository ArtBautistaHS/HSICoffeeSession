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
import com.example.hsicoffeeproject.components.CheckboxComponent
import com.example.hsicoffeeproject.components.ClickableLoginTextComponent
import com.example.hsicoffeeproject.components.DividerTextComponent
import com.example.hsicoffeeproject.components.HeadingTextComponent
import com.example.hsicoffeeproject.components.MyTextFieldComponent
import com.example.hsicoffeeproject.components.NormalTextComponent
import com.example.hsicoffeeproject.components.PasswordTextFieldComponent
import com.example.hsicoffeeproject.data.signup.SignupViewModel
import com.example.hsicoffeeproject.data.signup.SignupUIEvent
import com.example.hsicoffeeproject.navigation.PostOfficeAppRouter
import com.example.hsicoffeeproject.navigation.Screen
import com.example.hsicoffeeproject.navigation.SystemBackButtonHandler

@Composable
fun SignUpScreen(signupViewModel: SignupViewModel = viewModel()) {

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(labelValue = stringResource(id = R.string.first_name),
                painterResource(id = R.drawable.ic_profile_foreground),
                onTextSelected = {
                    signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                },
                errorStatus = signupViewModel.registrationUIState.value.firstNameError
            )
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.ic_profile_foreground),
                onTextSelected = {
                    signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                },
                errorStatus = signupViewModel.registrationUIState.value.lastNameError
            )
            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.ic_email),
                onTextSelected = {
                    signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                },
                errorStatus = signupViewModel.registrationUIState.value.emailError
            )
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_password),
                onTextSelected = {
                    signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                },
                errorStatus = signupViewModel.registrationUIState.value.passwordError
            )
            CheckboxComponent(
                value = stringResource(id = R.string.terms_and_condition),
                onTextSelected = {
                   PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                },
                onCheckedChange = {
                    signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                }
            )


            Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent(
                value = stringResource(id = R.string.register),
                onButtonClicked = {
                    signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                },
                isEnabled = signupViewModel.allValidationsPassed.value
            )

            Spacer(modifier = Modifier.height(40.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }
    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
    }
    if(signupViewModel.signUpInProgress.value){
        CircularProgressIndicator()
    }

}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}

