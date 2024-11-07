package com.example.jokefetcherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeRepository {
    private val _joke = MutableLiveData<Joke>()
    val joke: LiveData<Joke> = _joke

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchJoke() {
        RetrofitInstance.api.getRandomJoke().enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {
                    _joke.value = response.body()
                } else {
                    _error.value = "Error fetching joke."
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                _error.value = "Failed to fetch joke: ${t.message}"
            }
        })
    }
}