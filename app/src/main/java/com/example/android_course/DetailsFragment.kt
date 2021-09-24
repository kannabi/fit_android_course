package com.example.android_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class DetailsFragment: Fragment() {

    private val navigator: Navigator
        get() = activity as Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.text)
        textView.text = arguments?.getString(KEY_TEXT)
        view.findViewById<Button>(R.id.next_button)?.setOnClickListener {

        }
    }

    companion object {
        private const val KEY_TEXT = "KEY_TEXT"

        fun getInstance(text: String): DetailsFragment {
            return DetailsFragment().apply {
                arguments = bundleOf(
                    KEY_TEXT to text
                )
            }
        }
    }
}