package com.itis.androidsummerpractice

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.itis.androidsummerpractice.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment: Fragment(R.layout.fragment_personal_info) {
    private var binding: FragmentPersonalInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPersonalInfoBinding.bind(view)
        val player: Player? = findPlayerById(arguments?.getInt(ID))
        if (player != null) {
            extractValues(player, view)
        }
    }

    private fun findPlayerById(id: Int?) : Player? {
        PlayerRepository.list.forEach{
            if (it.id == id) {
                return it
            }
        }
        return null
    }

    private fun extractValues(player: Player, view: View) {
        binding?.run {
            tvName.text = "NAME: " + player.name
            tvDescription.text = "DESCRIPTION: " + player.description
            tvPosition.text = "POSITION: " + player.position
            tvNumber.text = "NUMBER: " + player.number.toString()
            tvCountry.text = "COUNTRY: " + player.country
            tvId.text = "ID: " + player.id.toString()

            Glide.with(view)
                .load(player.url)
                .placeholder(R.drawable.unknown_person)
                .error(R.drawable.img_not_found)
                .into(ivImage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ID = "ID";
        fun createBundle(id: Int) = bundleOf(
            ID to id
        )
    }
}
