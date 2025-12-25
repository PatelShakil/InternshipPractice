package com.techsavvy.exampleday2.data.api

import com.techsavvy.exampleday2.data.log.FcmLog
import com.techsavvy.exampleday2.models.User
import com.techsavvy.exampleday2.network.ApiRoutes
import com.techsavvy.exampleday2.utility.ApiResponse
import com.techsavvy.exampleday2.utility.Resource
import com.techsavvy.exampleday2.utility.TempResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.url
import jakarta.inject.Inject

class AuthApi @Inject constructor(
    private val client : HttpClient,
    private val log : FcmLog
) {
    //async function
    // MERE PASS AAYA ->  ------------------   MUJE DATA CHAHIYE ->  Continue
    //                ->  MUJE DATA CHAHIYE -> Continue Processing -> Continue

//    {
//        "status":true,
//        "message":"Request Successfull",
//        "data":"abd"
//    }


//    suspend fun getIsUniqueUser(username : String): ApiResponse<List<User>>{
//
//    }
    suspend fun getIsUniqueUser(username : String): Resource<TempResponse>{
    return try {
        Resource.Success(
            client.get {
                url(ApiRoutes.GET_IS_UNIQUE_USER_TEST + "/$username")
            }.body()
        )
    } catch (e: NoTransformationFoundException) {
        log.logException(e)
    } catch (e: ResponseException) {
        log.logException(e)
    } catch (e: ClientRequestException) {
        log.logException(e)
    } catch (e: ServerResponseException) {
        log.logException(e)
    } catch (e: Exception) {
        e.printStackTrace()
        log.logException(e)
    }
    }



}