package com.example.buryachenko_hw11_androidapp3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.buryachenko_hw11_androidapp3.databinding.ActivityMainBinding
import com.example.buryachenko_hw11_androidapp3.databinding.DialogFragmentBinding

class MyDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}