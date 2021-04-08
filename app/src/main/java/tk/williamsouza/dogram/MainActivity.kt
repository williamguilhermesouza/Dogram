package tk.williamsouza.dogram

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tk.williamsouza.dogram.adapters.DogRecyclerViewAdapter
import tk.williamsouza.dogram.models.Dog
import tk.williamsouza.dogram.repositories.DogRepository
import tk.williamsouza.dogram.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var dogsAdapter : DogRecyclerViewAdapter
    private var dogsList: ArrayList<Dog> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repository = DogRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)



        viewModel.dogResponse.observe(this, { response ->
            dogsList.add(Dog(response.message, response.status))
            addDataSet()
            dogsAdapter.notifyDataSetChanged()
            Log.d("dog", response.message)
        })

        for (i in 0..5) {
            viewModel.getDog()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val dogsView = findViewById<RecyclerView>(R.id.dogsRecyclerView)
        dogsView.layoutManager = LinearLayoutManager(this)
        val topSpacingDecoration = TopSpacingItemDecoration(30)
        dogsView.addItemDecoration(topSpacingDecoration)
        dogsAdapter = DogRecyclerViewAdapter()
        dogsView.adapter = dogsAdapter
    }

    private fun addDataSet() {
        dogsAdapter.submitList(dogsList)
    }
}