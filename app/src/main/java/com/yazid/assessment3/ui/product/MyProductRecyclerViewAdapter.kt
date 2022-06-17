package com.yazid.assessment3.ui.product

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yazid.assessment3.R

import com.yazid.assessment3.databinding.FragmentProductBinding
import com.yazid.assessment3.entity.DataX

class MyProductRecyclerViewAdapter :
    RecyclerView.Adapter<MyProductRecyclerViewAdapter.ViewHolder>() {

    private val data = mutableListOf<DataX>()

    fun updateData(newData: List<DataX>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: FragmentProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataX) = with(binding) {
            itemNumber.text = data.name
            content.text = data.price
            Glide.with(imageView.context).load(data.images[0].path)
                .error(R.drawable.ic_baseline_broken_image_24).into(imageView)
        }
    }

}