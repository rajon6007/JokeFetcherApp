package com.example.jokefetcherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(private var jokeList: List<Joke>) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val setupTextView: TextView = view.findViewById(R.id.textSetup)
        val punchlineTextView: TextView = view.findViewById(R.id.textPunchline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokeList[position]
        holder.setupTextView.text = joke.setup
        holder.punchlineTextView.text = joke.punchline
    }

    override fun getItemCount() = jokeList.size

    fun updateJokes(newJokeList: List<Joke>) {
        jokeList = newJokeList
        notifyDataSetChanged()
    }
}