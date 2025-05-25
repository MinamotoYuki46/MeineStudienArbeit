package com.example.apitest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MsgVM : ViewModel() {
    private val _msg = MutableStateFlow("Loading...")
    val msg: StateFlow<String> = _msg

    fun fetchMsg() {
        viewModelScope.launch {
            try {
                val response = APIClient.api_service.getMessage()
                _msg.value = response.msg
            } catch (e: Exception) {
                _msg.value = "Error: ${e.message}"
            }
        }
    }
}