package com.github.hyeyeon2371.archdemo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.github.hyeyeon2371.archdemo.R
import com.github.hyeyeon2371.archdemo.data.model.ListItem
import com.github.hyeyeon2371.archdemo.data.viewmodel.MainViewModel
import com.github.hyeyeon2371.archdemo.databinding.ItemListBinding
import com.github.hyeyeon2371.archdemo.view.activity.MainActivity

/**
 * @author Hyeyeon Park
 */
class ListAdapter : RecyclerView.Adapter<ListAdapter.Holder>() {
    private var list = mutableListOf<ListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DataBindingUtil.inflate<ItemListBinding>(
            LayoutInflater.from(parent.context), R.layout.item_list, parent, false
        )
        return Holder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    fun addItem(item: ListItem) {
        this.list.add(item)
        notifyItemInserted(itemCount - 1)
    }

    inner class Holder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {
            item.position = adapterPosition
            binding.item = item


            binding.viewModel = ViewModelProvider((binding.root.context) as MainActivity).get(MainViewModel::class.java)
        }
    }
}