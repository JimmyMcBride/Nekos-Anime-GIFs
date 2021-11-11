package com.example.nekosanimegifs.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nekosanimegifs.databinding.CategoryButtonBinding
import com.example.nekosanimegifs.extentions.layoutInflater
import com.example.nekosanimegifs.models.AnimeCategories

class CategoryAdapter(
    private val categories: MutableMap<String, AnimeCategories.CategoryInfo>,
    private val categorySelected: (Pair<String, AnimeCategories.CategoryInfo>) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = CategoryViewHolder.getInstance(parent)

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        categories.toList()[position].let { category ->
            holder.bind(category, categorySelected)
        }
    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(
        private val binding: CategoryButtonBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Pair<String, AnimeCategories.CategoryInfo>, categorySelected: (Pair<String, AnimeCategories.CategoryInfo>) -> Unit) = with(binding) {
            btnCategory.text = category.first
            btnCategory.setOnClickListener {
                categorySelected(category)
            }
        }

        companion object {
            fun getInstance(parent: ViewGroup) = CategoryButtonBinding.inflate(
                parent.layoutInflater, parent, false
            ).run { CategoryViewHolder(this) }
        }
    }
}
