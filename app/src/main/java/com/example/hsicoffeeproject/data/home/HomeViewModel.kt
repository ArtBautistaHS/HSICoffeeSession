package com.example.hsicoffeeproject.data.home

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hsicoffeeproject.navigation.PostOfficeAppRouter
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {

    private val TAG = HomeViewModel::class.simpleName

    val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun checkForActiveSession(){
        if(FirebaseAuth.getInstance().currentUser != null){

            Log.d(TAG,"Valid session")
            isUserLoggedIn.value = true
        }else{
            Log.d(TAG,"User is not logged in")
            isUserLoggedIn.value = false
        }
    }
}