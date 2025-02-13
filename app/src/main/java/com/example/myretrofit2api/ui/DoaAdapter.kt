package com.example.myretrofit2api.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit2api.data.response.ListDoaResponseItem
import com.example.myretrofit2api.databinding.ItemDoaBinding

class DoaAdapter(private val listDoa: ArrayList<ListDoaResponseItem>): RecyclerView.Adapter<DoaAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemDoaBinding): RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
        val tvAyat = binding.tvAyat
        val tvLatin = binding.tvLatin
        val tvArti = binding.tvArti
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doa = listDoa[position]
        holder.tvItem.text = doa.doa
        holder.tvAyat.text = doa.ayat
        holder.tvLatin.text = doa.latin
        holder.tvArti.text = doa.artinya

        holder.tvItem.setOnClickListener {
            if (holder.tvAyat.visibility == View.VISIBLE){
                holder.tvAyat.visibility = View.GONE
                holder.tvLatin.visibility = View.GONE
                holder.tvArti.visibility = View.GONE
            }else{
                holder.tvAyat.visibility = View.VISIBLE
                holder.tvLatin.visibility = View.VISIBLE
                holder.tvArti.visibility = View.VISIBLE
            }

        }
    }

    override fun getItemCount(): Int = listDoa.size
}

