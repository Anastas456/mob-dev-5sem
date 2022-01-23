package com.example.laba5


object Holder{

    private val myItems = mutableListOf<MyItem>()


    fun createItemList(msg: Int): MutableList<MyItem>{
        val item = MyItem(msg)
        myItems.add(item)
        return myItems
    }

}

data class MyItem(
    val msg: Int
)