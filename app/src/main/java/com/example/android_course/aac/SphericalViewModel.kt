package com.example.android_course.aac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SphericalViewModel(private val savedSavedStateHandle: SavedStateHandle): ViewModel() {
    private val _mutableState = MutableLiveData<State>().apply {
        savedSavedStateHandle.get<String>(TEXT_KEY)
            ?.let(::State)
            ?.let(::postValue)
    }
    val state: LiveData<State>
        get() = _mutableState

    fun onLolKek() {
        val currentStateValue = state.value
        val newState = currentStateValue?.copy(text = currentStateValue.text + "lol kek ")
            ?: State("lol kek ")

        savedSavedStateHandle[TEXT_KEY] = newState.text
        _mutableState.postValue(newState)
    }

    fun onClear() {
        _mutableState.postValue(State(""))
        savedSavedStateHandle[TEXT_KEY] = ""
    }

    data class State(
        val text: String
    )

    companion object {
        private const val TEXT_KEY = "TEXT_KEY"
    }
}