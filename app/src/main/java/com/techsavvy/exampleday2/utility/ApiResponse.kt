package com.techsavvy.exampleday2.utility


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    @SerialName("data")
    val data: T? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("status")
    val status: Boolean? = null
)

//User
//List<User>
//List<Block>