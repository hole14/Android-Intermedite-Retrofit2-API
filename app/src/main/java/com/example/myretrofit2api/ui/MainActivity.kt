package com.example.myretrofit2api.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myretrofit2api.R
import com.example.myretrofit2api.data.response.ListDoaResponse
import com.example.myretrofit2api.data.retrofit.ApiConfig
import com.example.myretrofit2api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRandomDoa()
    }

    private fun getRandomDoa() {
        showLoading(true)

        val client = ApiConfig.getApiService().getRandomDoa()
        client.enqueue(object : Callback<ListDoaResponse> {

            override fun onFailure(call: Call<ListDoaResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ListDoaResponse>,
                response: Response<ListDoaResponse>
            ) {

            }

        })
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }

}