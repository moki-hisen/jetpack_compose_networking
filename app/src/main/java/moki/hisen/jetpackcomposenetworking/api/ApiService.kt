package moki.hisen.jetpackcomposenetworking.api

import moki.hisen.jetpackcomposenetworking.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("ecad955bfec9c559df46")
    suspend fun getUsers(): List<User>
}