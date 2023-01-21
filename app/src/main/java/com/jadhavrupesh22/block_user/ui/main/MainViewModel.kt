package com.jadhavrupesh22.block_user.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.jadhavrupesh22.block_user.model.Post
import com.jadhavrupesh22.block_user.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel(),
    LifecycleObserver {
    val _postLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postLiveData: LiveData<List<Post>>
        get() = _postLiveData

    //get all Posts
    fun getPost() {
        viewModelScope.launch {
            delay(1000)
            mainRepository.getPost()
                .catch { e ->
                    Timber.e("getPost: ${e.message}")
                }.collect { response ->
                    Timber.d("getPost: $response")
                    _postLiveData.value = response
                }


        }
    }


}

