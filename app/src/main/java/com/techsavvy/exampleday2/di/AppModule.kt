package com.techsavvy.exampleday2.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.techsavvy.exampleday2.data.log.FcmLog
import com.techsavvy.exampleday2.data.log.FcmLogImpl
import com.techsavvy.exampleday2.network.NetworkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Purpose : Top level se jo class ka object chahiye usko return karna...

    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Provides
    fun provideNetworkHttpClient() = NetworkHttpClient().getHttpClient()

    @Provides
    fun provideFcmLog() : FcmLog = FcmLogImpl()
}