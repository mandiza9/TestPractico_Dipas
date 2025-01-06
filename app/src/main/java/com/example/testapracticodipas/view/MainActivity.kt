package com.example.testapracticodipas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapracticodipas.adapter.RecyclerViewAdapter
import com.example.testapracticodipas.databinding.ActivityMainBinding
import com.example.testapracticodipas.viewmodel.TestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var viewModel: TestViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        initViewModel()
        initSearch()
    }


    private fun initSearch(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                filterList( query )
                return false
            }

        })
    }

    private fun filterList(query: String){
        if(query.isNotEmpty()){
            val filterGames = viewModel.isliveDataList.value?.filter {
                it.name.contains(query,ignoreCase = true)
            }
            if ( filterGames != null ){
                adapter = RecyclerViewAdapter( filterGames, this )
                binding.recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
        else{
            adapter = RecyclerViewAdapter( viewModel.isliveDataList.value!!, this )
            binding.recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    private fun initViewModel() {

        binding.progressBar.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this)[TestViewModel::class.java]
        viewModel.loadData()

        observeData()
    }

    private fun observeData() {
        viewModel.getLiveData().observe(this) {

            binding.progressBar.visibility = View.INVISIBLE

            if (it != null) {
                if (it.isEmpty()) {
                    //No hay info
                    }
                else{
                    adapter = RecyclerViewAdapter( it, this )
                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                    }
                }
            }
    }

}