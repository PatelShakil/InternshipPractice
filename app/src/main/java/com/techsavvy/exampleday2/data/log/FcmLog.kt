package com.techsavvy.exampleday2.data.log

import com.techsavvy.exampleday2.utility.Resource
import io.ktor.client.statement.HttpResponse

interface FcmLog {
    suspend fun logException(response: HttpResponse): Resource.Failure

    suspend fun logException(throwable: Exception):Resource.Failure
}