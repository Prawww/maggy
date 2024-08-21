package com.example.maggy

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maggy.databinding.FragmentDisplayBinding


class DisplayFragment : Fragment() {

    private lateinit var viewModel: DisplayViewModel
    private var _binding : FragmentDisplayBinding? = null
    val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?){

        val apiService = RetrofitClient.instance // or however you instantiate ApiService
        val repo = Repo(apiService)// Initialize your Repo object
        val factory = DisplayViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory).get(DisplayViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        viewModel.posts.observe(viewLifecycleOwner, Observer {

            recyclerView.adapter = PostAdapter(it)

        })



    }

}