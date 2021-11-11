package com.example.nekosanimegifs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.nekosanimegifs.adapter.GIFListAdapter
import com.example.nekosanimegifs.databinding.FragmentFullScreenBinding
import com.example.nekosanimegifs.databinding.FragmentGifListBinding
import com.example.nekosanimegifs.extentions.loadUrl
import com.example.nekosanimegifs.viewmodel.NekosViewModel
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController


class FullScreenFragment : Fragment() {

    private var _binding: FragmentFullScreenBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<FullScreenFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentFullScreenBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivAnimeGif.loadUrl(args.gif.url)
        binding.tvAnimeName.text = args.gif.animeName
        binding.btnClose.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}