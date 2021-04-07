package tk.williamsouza.dogram.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tk.williamsouza.dogram.models.Dog
import tk.williamsouza.dogram.repositories.DogRepository

class MainViewModel(private val repository: DogRepository): ViewModel() {
    val dogResponse: MutableLiveData<Dog> = MutableLiveData()

    fun getDog() {
        viewModelScope.launch {
            val response = repository.getDog()
            dogResponse.value = response
        }
    }
}