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
import com.dragdrop.interfaces.OnCallBackListener
import com.dragdrop.models.DragModel
import com.dragdrop.utils.DragListener

class DragAdapter(val onCallBackListener: OnCallBackListener) :
    RecyclerView.Adapter<DragAdapter.MyHolder>() {
    var list = arrayListOf<DragModel>()


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
                if (list.isEmpty())
                    onCallBackListener.isListEmpty(true)
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

    class MyHolder(val binding: ItemDragLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DragModel) {
            binding.model = data
        }
    }

    fun addItem(newList: List<DragModel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


}