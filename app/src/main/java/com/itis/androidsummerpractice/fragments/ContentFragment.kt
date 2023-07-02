package com.itis.androidsummerpractice.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.androidsummerpractice.R
import com.itis.androidsummerpractice.databinding.FragmentContentBinding

class ContentFragment: Fragment(R.layout.fragment_content) {

    private var binding: FragmentContentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentContentBinding.bind(view)
        binding?.run{
            btnToDisplay.setOnClickListener{
                findNavController().navigate(
                    R.id.action_contentFragment_to_displayFragment,
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
