package com.example.myretrofit2api.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myretrofit2api.R
import com.example.myretrofit2api.data.response.ListDoaResponseItem
import com.example.myretrofit2api.data.retrofit.ApiConfig
import com.example.myretrofit2api.databinding.ActivityListDoaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.rcListDoa.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rcListDoa.addItemDecoration(itemDecoration)

        getAllDoa()

        val client = ApiConfig.getApiService().getListDoa()
        client.enqueue(object : Callback<List<ListDoaResponseItem>> {

            override fun onFailure(call: Call<List<ListDoaResponseItem>>, t: Throwable) {
                showLoading(false)
                Toast.makeText(this@ListDoaActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<ListDoaResponseItem>>,
                response: Response<List<ListDoaResponseItem>>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        setListData(responseBody)
                    } else {
                        Toast.makeText(this@ListDoaActivity, "Data Kosong", Toast.LENGTH_SHORT)
                            .show()
                    }
                }else{
                    Toast.makeText(this@ListDoaActivity, "Not Found", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private fun setListData(doaResponseItems: List<ListDoaResponseItem>) {
        val listDoa = ArrayList<String>()
        for (doa in doaResponseItems) {
            listDoa.add(doa.doa)

            val adapter = DoaAdapter(listDoa)
            binding.rcListDoa.adapter = adapter
        }

    }

    private fun getAllDoa() {
        showLoading(true)
    }

    private fun showLoading(isLoading: Boolean) {
        if(isLoading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}