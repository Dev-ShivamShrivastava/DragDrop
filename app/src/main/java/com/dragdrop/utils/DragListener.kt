package com.dragdrop.utils

import android.content.Context
import android.graphics.Rect
import android.media.MediaPlayer
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.view.View.OnDragListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dragdrop.R
import com.dragdrop.adapters.DragAdapter
import com.dragdrop.adapters.DropAdapter
import com.google.android.material.card.MaterialCardView


class DragListener(val returnCall: () -> Unit) : OnDragListener {
    override fun onDrag(v: View, event: DragEvent): Boolean {
        when (event.action) {
            DragEvent.ACTION_DRAG_ENDED -> {
                val dragView: MaterialCardView = v as MaterialCardView
                val rvDrop = v.rootView.findViewById<View>(R.id.rvDrop) as RecyclerView
                val rvDrag = v.rootView.findViewById<View>(R.id.rvDrag) as RecyclerView
                val owner = rvDrop.parent as ViewGroup
                val dropView = rvDrop.findChildViewUnder(event.x,event.y-300)
                val dropAdapter = rvDrop.adapter as DropAdapter
                val dragAdapter = rvDrag.adapter as DragAdapter
                if (dropView != null) {
                    if (dragView.tag.toString().equals(dropView.tag.toString(), true)){
                       val dragPosition = dragAdapter.list.indexOfFirst {
                            it.name?.equals(dragView.tag.toString(),true) == true
                        }
                        val dropPosition = dropAdapter.list.indexOfFirst {
                            it.name?.equals(dropView.tag.toString(),true) == true
                        }

                        if (dragPosition != -1 && dropPosition!=-1){
                           val dragData = dragAdapter.list[dragPosition]
                           dropAdapter.list[dropPosition].apply {
                               this.image = dragData.image
                               this.isDrop=true
                           }
                            dropView.context.playName(dragData.typeName)
                            dropAdapter.notifyDataSetChanged()
                            dragAdapter.list.removeAt(dragPosition)
                            dragAdapter.notifyDataSetChanged()
                        }
                        returnCall()
                    }else{
                        dropView.context.playName()
                        returnCall()
                    }
                } else {
                    dragView.context.playName(isPlay = false)
                    returnCall()
                }
            }
        }
        return true
    }

    private fun Context.playName(raw:Int=R.raw.wrong, isPlay:Boolean=true){
        if (isPlay){
            val mp = MediaPlayer.create(this,raw)
            mp.start()
        }
    }


    private fun findViewAt(viewGroup: ViewGroup, x: Int, y: Int): View? {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ViewGroup) {
                val foundView = findViewAt(child, x, y)
                if (foundView != null && foundView.isShown) {
                    return foundView
                }
            } else {
                val location = IntArray(2)
                child.getLocationOnScreen(location)
                val rect = Rect(
                    location[0],
                    location[1],
                    location[0] + child.width,
                    location[1] + child.height
                )
                if (rect.contains(x, y)) {
                    return child
                }
            }
        }
        return null
    }

}