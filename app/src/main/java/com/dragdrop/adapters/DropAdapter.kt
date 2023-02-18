package com.dragdrop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dragdrop.R
import com.dragdrop.databinding.ItemDropLayoutBinding
import com.dragdrop.models.DropModel

class DropAdapter : RecyclerView.Adapter<DropAdapter.MyHolder>() {

    var list = arrayListOf<DropModel>(
        DropModel(name = "Elephant", image = R.drawable.elephant),
        DropModel(name = "Horse", R.drawable.horse),
        DropModel(name = "Lion", R.drawable.lion),
        DropModel(name = "Tiger", R.drawable.tiger),
        DropModel(name = "Monkey", R.drawable.monkey),
        DropModel(name = "Fox", R.drawable.fox),
        DropModel(name = "Dog", R.drawable.dog),
        DropModel(name = "Cat", R.drawable.cat),
        DropModel(name = "Goat", R.drawable.goat),
        DropModel(name = "Pig", R.drawable.pig),
        DropModel(name = "Giraffe", R.drawable.giraffe),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyHolder(ItemDropLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.mcvDrop.tag = list[position].name
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class MyHolder(val binding: ItemDropLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:DropModel){
            binding.model = data
        }
    }

    fun addItem(newList: List<DropModel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }



}