package com.example.laba4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laba4.databinding.ListItemsBinding

class Adapter(private val list: List<Person>,
    private val clickItem: (Person) -> Unit,
    private val clickLike: (Person) -> Unit
): RecyclerView.Adapter<Adapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, clickItem, clickLike)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val person = list[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Holder internal constructor(
        private val binding: ListItemsBinding,
        private val clickItem: (Person) -> Unit,
        private  val clickLike: (Person) -> Unit
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(person: Person)= binding.run{
            name.text = person.name
            photo.setImageResource(person.imageDrawableRes)
            years.text = person.years
            description.text = person.description
            gender.text = person.gender

            binding.root.setOnClickListener{
                clickItem.invoke(person)
            }
            binding.like.setOnClickListener{
                clickLike.invoke(person)
            }
        }
    }
}