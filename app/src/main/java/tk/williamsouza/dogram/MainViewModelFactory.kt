package tk.williamsouza.dogram

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tk.williamsouza.dogram.repositories.DogRepository
import tk.williamsouza.dogram.viewmodels.MainViewModel

class MainViewModelFactory(private val repository: DogRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}