package com.example.nekosanimegifs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nekosanimegifs.databinding.FragmentCategoryBinding
import com.example.nekosanimegifs.models.AnimeCategories
import com.example.nekosanimegifs.viewmodel.NekosViewModel
import com.example.nekosanimegifs.adapter.CategoryAdapter

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private val nekosVM by activityViewModels<NekosViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCategoryBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeObservables()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observeObservables() = with(nekosVM) {
        loadCategories()
        categories.observe(viewLifecycleOwner) { categories ->
            binding.rvCategories.adapter = CategoryAdapter(categories.getCategoriesMap(), ::categoryClicked)
        }
    }

    private fun categoryClicked(category: Pair<String, AnimeCategories.CategoryInfo>) = with(findNavController()) {
        val action = category.second.max?.toInt()?.let {
            CategoryFragmentDirections.goToGIFListFragment(category.first,
                it
            )
        }
        if (action != null) {
            navigate(action)
        }
    }
}