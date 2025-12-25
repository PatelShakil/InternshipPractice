package com.techsavvy.exampleday2.utility


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TempResponse(
    @SerialName("data")
    val `data`: Boolean? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("status")
    val status: Int? = null
)