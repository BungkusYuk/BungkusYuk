package com.example.segarbox.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segarbox.data.local.model.DummyModelTransaction
import com.example.segarbox.databinding.FragmentInProgressBinding
import com.example.segarbox.ui.adapter.DummyAdapterTransaction

class InProgressFragment : Fragment() {

    private var _binding: FragmentInProgressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInProgressBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        setAdapter()
    }

    private fun setAdapter() {
        val listItem = arrayListOf(
            DummyModelTransaction(),
            DummyModelTransaction(),
            DummyModelTransaction(),
            DummyModelTransaction(),
            DummyModelTransaction(),
            DummyModelTransaction(),
            DummyModelTransaction(),
            DummyModelTransaction()
        )
        val adapterTransaction = DummyAdapterTransaction("In Progress")
        adapterTransaction.submitList(listItem)

        binding.rvTransaction.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapterTransaction
        }
    }
}