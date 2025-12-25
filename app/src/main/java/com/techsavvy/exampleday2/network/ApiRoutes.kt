package com.techsavvy.exampleday2.network

object ApiRoutes {
    val BASE_URL = "https://api.savvyqr.techsavvysolution.in/api"
    val BASE_URL_TEST = "https://api.gi1superverse.com/api"

    // Route Name -> <REQUEST_TYPE>_<ROUTE_NAME>
    // GET -> DATA FETCHING
    // POST -> DATA SENDING


    val GET_IS_UNIQUE_USER_TEST = "$BASE_URL_TEST/user/isuniqueuser"
    val POST_LOGIN = "$BASE_URL/login"
    val POST_REGISTER = "$BASE_URL/register"
    val GET_IS_UNIQUE_USER = "$BASE_URL/is-unique-user"
}