package com.techsavvy.exampleday2.models

data class User (
    val email : String,
    val password :String
){
    constructor():this("","")
}