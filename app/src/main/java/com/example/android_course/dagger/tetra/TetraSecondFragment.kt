package com.example.android_course.dagger.tetra

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_course.R
import javax.inject.Inject

class TetraSecondFragment : Fragment() {

    @Inject
    lateinit var presenter: TetraPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as TetrahedronActivity).tetraComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tetra_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun getInstance() = TetraSecondFragment()
    }
}