package com.example.testapracticodipas.viewmodel

import android.provider.DocumentsContract
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapracticodipas.model.GamesList
import com.example.testapracticodipas.model.Test
import com.example.testapracticodipas.repository.TestRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(private val repo: TestRepository): ViewModel(){

    private var liveDataList: MutableLiveData<List<GamesList>> = MutableLiveData()

    val isliveDataList: LiveData<List<GamesList>> = liveDataList

    fun getLiveData(): MutableLiveData<List<GamesList>> {
        return liveDataList
    }

    fun loadData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val response = repo.getGames()
                liveDataList.postValue( response )
            }
        }
    }

}