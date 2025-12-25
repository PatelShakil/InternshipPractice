package com.techsavvy.exampleday2.ui.auth

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.techsavvy.exampleday2.data.api.AuthApi
import com.techsavvy.exampleday2.models.User
import com.techsavvy.exampleday2.utility.Resource
import com.techsavvy.exampleday2.utility.TempResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth : FirebaseAuth,
    private val store : FirebaseFirestore,
    private val authApi : AuthApi
): ViewModel() {

    private var _response = MutableStateFlow<Resource<TempResponse>?>(null)
    val response = _response

    init {
    }

    fun callApi(username : String)=viewModelScope.launch{
        _response.value = Resource.Loading
        _response.value = authApi.getIsUniqueUser(username)


    }



    fun login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { it->
                if(it.isComplete){
                    if(it.isSuccessful){
                        Log.d("LOGGED IN",it.result.user?.email.toString())
                    }else{
                        Log.d("ERROR",it.exception.toString())
                    }
                }

            }
    }

    fun register(email: String,password: String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { it->
                if(it.isComplete){
                    if(it.isSuccessful){
                        Log.d("REGISTER",it.result.user?.email.toString())
                        //always ignore password
                        val user = User(email,password)
                        store.collection("users")
                            .document(it.result.user?.uid.toString())
                            .set(user)
                            .addOnCompleteListener {
                                if(it.isComplete){
                                    if(it.isSuccessful){
                                        Log.d("USER CREATED","User Registered Successfully")
                                    }else{
                                        Log.d("ERROR REGISTER",it.exception.toString())
                                    }
                                }
                            }
                    }else{
                        Log.d("ERROR",it.exception.toString())
                    }
                }

            }
    }

}