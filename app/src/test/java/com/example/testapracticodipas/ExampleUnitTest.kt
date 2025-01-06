package com.example.testapracticodipas

import com.example.testapracticodipas.data.Apis
import com.example.testapracticodipas.model.GamesList
import com.example.testapracticodipas.repository.TestRepository
import com.example.testapracticodipas.room.TestDatabaseDao
import com.example.testapracticodipas.view.MainActivity
import com.example.testapracticodipas.viewmodel.TestViewModel
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var viewModel: TestViewModel

    @Before
    fun setup(){
        //viewModel = TestViewModel(TestRepository(Apis(),TestDatabaseDao()))
    }

    @Test
    fun getLoadTest() {

    }
}