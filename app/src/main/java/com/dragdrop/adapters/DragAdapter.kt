package com.dragdrop.adapters

import android.content.ClipData
import android.content.ClipDescription
import android.media.MediaPlayer
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dragdrop.R
import com.dragdrop.databinding.ItemDragLayoutBinding
import com.dragdrop.models.DragModel
import com.dragdrop.utils.DragListener

class DragAdapter : RecyclerView.Adapter<DragAdapter.MyHolder>() {
     var list = arrayListOf<DragModel>(
        DragModel(name = "Elephant", image = R.drawable.elephant, typeName = R.raw.elephant),
        DragModel(name = "Horse", R.drawable.horse, typeName = R.raw.horse),
        DragModel(name = "Lion", R.drawable.lion, typeName = R.raw.lion),
        DragModel(name = "Tiger", R.drawable.tiger, typeName = R.raw.tiger),
        DragModel(name = "Monkey", R.drawable.monkey, typeName = R.raw.monkey),
        DragModel(name = "Fox", R.drawable.fox,typeName = R.raw.fox),
        DragModel(name = "Dog", R.drawable.dog,typeName = R.raw.dog),
        DragModel(name = "Cat", R.drawable.cat,typeName = R.raw.cat),
        DragModel(name = "Goat", R.drawable.goat,typeName = R.raw.goat),
        DragModel(name = "Pig", R.drawable.pig,typeName = R.raw.pig),
        DragModel(name = "Giraffe", R.drawable.giraffe,typeName = R.raw.giraffe),
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyHolder(
        ItemDragLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.binding.mcvDrag.tag = list[position].name
        holder.bind(list[position])

        holder.binding.mcvDrag.setOnLongClickListener { v ->
            val item = ClipData.Item(v.tag.toString() as CharSequence)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val dragData = ClipData(v.tag.toString(), mimeTypes, item)
            val myShadow = View.DragShadowBuilder(holder.binding.mcvDrag)
            holder.binding.mcvDrag.setOnDragListener(DragListener {
                holder.binding.mcvDrag.setOnDragListener(null)
            })

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(dragData, myShadow, null, 0)
            } else {
                v.startDrag(dragData, myShadow, null, 0)
            }
            true
        }


    }

    override fun getItemCount() = list.size

    class MyHolder(val binding: ItemDragLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DragModel){
            binding.model = data
        }
    }


}