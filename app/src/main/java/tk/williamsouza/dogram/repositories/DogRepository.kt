package tk.williamsouza.dogram.repositories

import tk.williamsouza.dogram.api.RetrofitInstance
import tk.williamsouza.dogram.models.Dog

class DogRepository {
    suspend fun getDog(): Dog {
        return RetrofitInstance.api.getDog()
    }
 }