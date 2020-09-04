package com.droidafricana.protocodetest.service

import com.droidafricana.protocodetest.models.Order
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


private const val BASE_URL = "URL here"

/*Build the Moshi object that Retrofit will be using*/
val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val client: OkHttpClient = OkHttpClient.Builder()
    .callTimeout(30, TimeUnit.SECONDS)
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()

/*Build a retrofit object using a Moshi converter with the Moshi object.*/
val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .client(client)
    .build()


interface OrderApiService {
    @GET("orders")
    suspend fun getOrdersAsync():
            Response<Order>

    @POST("/orders")
    @FormUrlEncoded
    suspend fun saveOrder(
        @Field("title") title: String? = null,
        @Field("body") body: String? = null,
        @Field("userId") userId: Long? = null
    ): Response<Order>
}

object OrderApi {
    val orderRetrofitService: OrderApiService by lazy { retrofit.create(OrderApiService::class.java) }
}