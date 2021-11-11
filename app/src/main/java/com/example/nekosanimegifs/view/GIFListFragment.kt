package com.example.nekosanimegifs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nekosanimegifs.adapter.GIFListAdapter
import com.example.nekosanimegifs.databinding.FragmentGifListBinding
import com.example.nekosanimegifs.models.AnimeCategories
import com.example.nekosanimegifs.models.AnimeGIFList
import com.example.nekosanimegifs.models.Url
import com.example.nekosanimegifs.viewmodel.NekosViewModel

class GIFListFragment : Fragment() {

    private var _binding: FragmentGifListBinding? = null
    private val binding get() = _binding!!
    private val nekosVM by activityViewModels<NekosViewModel>()

    private val args by navArgs<GIFListFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentGifListBinding.inflate(
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
        loadGIFs(args.categoryName, args.categoryMax)
        gifs.observe(viewLifecycleOwner) { gifs ->
            binding.rvImages.adapter = GIFListAdapter(gifs, ::gifClicked)
        }
    }

    private fun gifClicked(gif: Url) = with(findNavController()) {
        val action = GIFListFragmentDirections.goToFullScreenFragment(gif)
        navigate(action)
    }

}