package com.example.learningkotlinapp2.personalData

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.learningkotlinapp2.database.PersonalData
import com.example.learningkotlinapp2.databinding.PersonalDataRecyclerViewResourceBinding

// Implementing the Adapter to the application.


class PersonalDataAdapter : androidx.recyclerview.widget.ListAdapter<PersonalData, PersonalDataAdapter.ViewHolder>(PersonalDataDiffCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  layoutInflater = LayoutInflater.from(parent.context)
        val binding = PersonalDataRecyclerViewResourceBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val binding: PersonalDataRecyclerViewResourceBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: PersonalData){
            binding.personalData = item
            binding.executePendingBindings()
        }

    }

    class PersonalDataDiffCallBack: DiffUtil.ItemCallback<PersonalData>(){
        override fun areItemsTheSame(oldItem: PersonalData, newItem: PersonalData): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PersonalData, newItem: PersonalData): Boolean {
            return oldItem == newItem
        }

    }
}

