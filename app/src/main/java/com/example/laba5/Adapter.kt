package com.example.laba5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laba5.databinding.ListBinding

class Adapter (var list: MutableList<MyItem>): RecyclerView.Adapter<Adapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val binding = ListBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Holder internal constructor(
            private val binding:ListBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(myItem: MyItem) = binding.run {
            itemText.text = myItem.msg.toString()
        }
    }
}