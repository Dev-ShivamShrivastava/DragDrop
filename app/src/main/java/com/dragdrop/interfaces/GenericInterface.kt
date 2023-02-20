package com.dragdrop.interfaces

interface GenericInterface<T> {
    fun genericCallBack(position:Int?=null, type:String?=null,data:T?=null)
}