package com.itis.androidsummerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.androidsummerpractice.databinding.FragmentListBinding

class ListFragment: Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var adapter: PlayerAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = PlayerAdapter(
            list = PlayerRepository.list,
            glide = Glide.with(this),
            onItemClick = {
                findNavController()
                    .navigate(
                        R.id.action_listFragment_to_personalInfoFragment,
                        PersonalInfoFragment.createBundle(it.id)
                    )
            })
        binding?.rvPlayer?.adapter = adapter
    }

}
