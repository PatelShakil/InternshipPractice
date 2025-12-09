package com.techsavvy.exampleday2.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class HomeViewModel @Inject constructor(

)  : ViewModel(){

    private var _namesList = MutableStateFlow<MutableList<String>>(mutableListOf())
    val namesList = _namesList

    fun addName(name:String){
        _namesList.value.add(name)
        Log.d("NameList",_namesList.value.toString())
    }

}