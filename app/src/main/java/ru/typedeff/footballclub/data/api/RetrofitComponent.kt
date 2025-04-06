package ru.typedeff.footballclub.data.api

import android.content.Context
import ru.typedeff.footballclub.utils.API_ENDPOINT
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitComponent(context: Context) {

    private val userAgentInterceptor = Interceptor { chain ->
        val originalRequest: Request = chain.request()

        val requestWithUserAgent: Request = originalRequest.newBuilder()
            .header("X-Auth-Token", "6007fe04cdc548f39a280b7a795b83e2")
            .build()
        chain.proceed(requestWithUserAgent)
    }

    private fun getLogger(): HttpLoggingInterceptor {
        val result = HttpLoggingInterceptor()
        result.level = HttpLoggingInterceptor.Level.BODY
        return result
    }


    private var apiService: ApiService

    init {

        val timeout = 5 * 1000L

        val httpClient = OkHttpClient.Builder().apply {
            connectTimeout(timeout, TimeUnit.SECONDS)
            readTimeout(timeout, TimeUnit.SECONDS)
            writeTimeout(timeout, TimeUnit.SECONDS)

            addInterceptor(getLogger())
            networkInterceptors().add(userAgentInterceptor)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .client(httpClient.build())


            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .build()

        apiService = retrofit.create(ApiService::class.java)

    }

    fun getApi() = apiService
}