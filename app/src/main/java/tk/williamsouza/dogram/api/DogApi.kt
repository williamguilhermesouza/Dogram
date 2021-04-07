package tk.williamsouza.dogram.api

import retrofit2.http.GET
import tk.williamsouza.dogram.models.Dog

interface DogApi {
    @GET("breeds/image/random")
    suspend fun getDog(): Dog
}