package com.itis.androidsummerpractice.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.androidsummerpractice.R
import com.itis.androidsummerpractice.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding?.run{
            btnToDisplay.setOnClickListener{
                findNavController().navigate(
                    R.id.action_homeFragment_to_displayFragment,
                    DisplayFragment.createBundle(javaClass.name)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
