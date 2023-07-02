package com.itis.androidsummerpractice.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.itis.androidsummerpractice.R
import com.itis.androidsummerpractice.databinding.FragmentDisplayBinding

class DisplayFragment: Fragment(R.layout.fragment_display) {
    private var binding: FragmentDisplayBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDisplayBinding.bind(view)
        val className = arguments?.getString("ARG_CLASS_NAME")
        if (className != null) {
            Snackbar.make(view, className, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun createBundle(className: String): Bundle {
            val bundle = Bundle()
            bundle.putString("ARG_CLASS_NAME", className)
            return bundle
        }
    }
}
