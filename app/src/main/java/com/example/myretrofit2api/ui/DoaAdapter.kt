package com.example.myretrofit2api.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit2api.databinding.ItemDoaBinding

class DoaAdapter(private val listDoa: ArrayList<String>): RecyclerView.Adapter<DoaAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemDoaBinding): RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doa = listDoa[position]
        holder.tvItem.text = doa
    }

    override fun getItemCount(): Int = listDoa.size
}