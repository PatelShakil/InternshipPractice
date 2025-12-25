package com.techsavvy.exampleday2.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import jakarta.inject.Inject
import kotlinx.serialization.json.Json

class NetworkHttpClient @Inject constructor(){


    fun getHttpClient() = HttpClient(Android) {

        engine {
            connectTimeout = 60_000
            socketTimeout = 60_000
        }

        install(ContentNegotiation){
            //XML
            //JSON
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys=true
                },
                contentType = ContentType.Application.Json
            )
        }

        install(Logging){
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("KTOR_LOGGER",message)
                }
            }
            level = LogLevel.ALL
        }

        install(ResponseObserver){
            onResponse { response ->
                Log.d("HTTP Status", "${response.status.value}")
            }
        }

        install(DefaultRequest){
            //token
            header("Content-Type","application/json")
//            header("Authorization","Bearer ${token}" )
        }

    }

}