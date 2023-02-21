package com.dragdrop.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dragdrop.R
import com.dragdrop.databinding.ItemHomeLayoutBinding
import com.dragdrop.models.HomeModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ItemHolder>() {
    var list = arrayListOf<HomeModel>(
        HomeModel(categoryName = "Animals", categoryIcon = R.raw.animals),
        HomeModel(categoryName = "Fruits", categoryIcon = R.raw.fruits),
        HomeModel(categoryName = "Insects", categoryIcon = R.raw.insects),
        HomeModel(categoryName = "Flowers", categoryIcon = R.raw.flowers),
        HomeModel(categoryName = "Birds", categoryIcon = R.raw.birds),
//        HomeModel(categoryName = "Body part", categoryIcon = R.drawable.body)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        ItemHomeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(list[position])

        holder.binding.mcvCategory.setOnClickListener {
            holder.binding.mcvCategory.findNavController()
                .navigate(R.id.homeToDragDrop, Bundle().apply {
                    putString("type", list[position].categoryName)
                })
        }
    }

    override fun getItemCount() = list.size

    class ItemHolder(val binding: ItemHomeLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HomeModel) {
            binding.model = data
        }
    }

}