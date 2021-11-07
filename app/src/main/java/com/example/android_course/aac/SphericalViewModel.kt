package com.example.android_course.aac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SphericalViewModel(): ViewModel() {
    private val _mutableState = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _mutableState

    fun onLolKek() {
        val currentStateValue = state.value
        _mutableState.postValue(
            currentStateValue?.copy(text = currentStateValue.text + "lol kek ")
                ?: State("lol kek ")
        )
    }

    data class State(
        val text: String
    )
}