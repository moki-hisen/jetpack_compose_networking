package moki.hisen.jetpackcomposenetworking.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import moki.hisen.jetpackcomposenetworking.api.RetrofitClient
import moki.hisen.jetpackcomposenetworking.model.User

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchUsers()
    }
    fun fetchUsers(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = RetrofitClient.apiService.getUsers()
                _users.value = result
            }catch (e: Exception){
                Log.e("UserViewModel", "Error: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}