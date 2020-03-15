package com.sammomichael.yapper

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sammomichael.yapper.entities.Businesses
import com.sammomichael.yapper.entities.reviews.Review
import com.sammomichael.yapper.entities.reviews.Reviews
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

class YelpService {
    val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        })
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.YELP_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .client(okHttpClient)
        .build()

    val yelpService: YelpApiService by lazy {
        retrofit.create(YelpApiService::class.java)
    }
}

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    lateinit var listOfReviews: MutableList<Reviews>
    private lateinit var yelpService: YelpApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        yelpService = YelpService().yelpService
        loadData()
        listOfReviews = mutableListOf<Reviews>()
    }

    fun loadData() {
        async(Dispatchers.IO) {
            var businesses = yelpService.getBusinesses(
                location = "nyc",
                limit = "1"
            )
            businesses.businesses?.forEach {
                var currentReviews = yelpService.getReviews(id = it?.id.toString())
                listOfReviews.add(currentReviews)
            }
            listOfReviews.forEach {
                Log.d(TAG, it.reviews?.size.toString())
            }
        }
    }

    companion object {
        private const val TAG = "MAIN_ACTIVITY"
    }
}

interface YelpApiService {
    @GET("businesses/search")
    suspend fun getBusinesses(
        @Header(Constants.AUTHORIZATION) apiKey: String = Constants.YELP_TOKEN,
        @Query(Constants.YELP_LOCATION_QUERY_PARAMETER) location: String = Constants.NYC,
        @Query(Constants.YELP_LIMIT_PARAMETER) limit: String = Constants.YELP_LIMIT_PARAMETER_MAX
    ): Businesses

    @GET("businesses/{id}/reviews")
    suspend fun getReviews(
        @Header(Constants.AUTHORIZATION) apiKey: String = Constants.YELP_TOKEN,
        @Path("id") id: String
    ) : Reviews
}

