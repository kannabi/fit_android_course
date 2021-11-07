package com.example.android_course.aac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_course.R
import com.example.android_course.databinding.FragmentBindExampleBinding

class BindExampleFragment : Fragment() {

    private lateinit var binding: FragmentBindExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_bind_example, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBindExampleBinding.bind(view)
        binding.exampleText.text = "lol kek"
    }

    companion object {
        fun getInstance(): BindExampleFragment = BindExampleFragment()
    }
}