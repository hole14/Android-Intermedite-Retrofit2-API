package com.example.myretrofit2api.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myretrofit2api.R
import com.example.myretrofit2api.data.response.ListDoaResponse
import com.example.myretrofit2api.data.response.ListDoaResponseItem
import com.example.myretrofit2api.data.retrofit.ApiConfig
import com.example.myretrofit2api.databinding.ActivityMainBinding
import com.google.gson.Gson
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRandomDoa()

        binding.btnAllDoa.setOnClickListener{
            startActivity(Intent(this@MainActivity, ListDoaActivity::class.java))
        }
    }

    private fun getRandomDoa() {
        showLoading(true)

        val client = ApiConfig.getApiService().getRandomDoa()
        client.enqueue(object : Callback<List<ListDoaResponseItem>> {

            override fun onFailure(call: Call<List<ListDoaResponseItem>>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<ListDoaResponseItem>>, response: Response<List<ListDoaResponseItem>>){

                showLoading(false)
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        val doa = responseBody[0]
                        binding.tvJudul.text = doa.doa
                        binding.tvLatin.text = doa.latin
                        binding.tvArti.text = doa.artinya
                        binding.tvAyat.text = doa.ayat
                    }
                }
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