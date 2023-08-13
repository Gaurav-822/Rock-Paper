package com.example.rockpaperscissorsrpc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rockpaperscissorsrpc.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.util.logging.Logger.global

var score = 0

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start of code


        val rock: Button = binding.rock
        val paper: Button = binding.paper
        val sci: Button = binding.sci
        val reset: Button = binding.reset

        val result: TextView = binding.result

        rock.setOnClickListener{rock(result)}
        paper.setOnClickListener{paper(result)}
        sci.setOnClickListener{sci(result)}
        reset.setOnClickListener{reset(result)}

    }
    // Functions

    private fun rock(result: TextView){
        binding.userInp.setImageResource(R.drawable.rock_icon)
        val random_no: Int = (1..3).random()
        imageChanger(random_no)
        when (random_no) {
            1 -> result.text = "DRAW!"
            2 -> result.text = "LOSS!"
            3 -> score(result)
        }
    }

    private fun paper(result: TextView){
        binding.userInp.setImageResource(R.drawable.paper_icon)
        val random_no: Int = (1..3).random()
        imageChanger(random_no)
        when (random_no) {
            1 -> score(result)
            2 -> result.text = "DRAW!"
            3 -> result.text = "LOSS!"
        }
    }

    private fun sci(result: TextView){
        binding.userInp.setImageResource(R.drawable.scissors_icon)
        val random_no: Int = (1..3).random()
        imageChanger(random_no)
        when (random_no) {
            1 -> result.text = "LOSS!"
            2 -> score(result)
            3 -> result.text = "DRAW!"
        }
    }
    private fun imageChanger(random_no: Int){
        when (random_no) {
            1 -> binding.randomInp.setImageResource(R.drawable.rock_icon)
            2 -> binding.randomInp.setImageResource(R.drawable.paper_icon)
            3 -> binding.randomInp.setImageResource(R.drawable.scissors_icon)
        }
    }
    private fun reset(result: TextView){
        com.example.rockpaperscissorsrpc.score = 0
        binding.score.text = "SCORE: 0"
        result.text = "RESET ✔"
    }
    private fun score(result: TextView){
        result.text = "WON!"
        com.example.rockpaperscissorsrpc.score += 1
        binding.score.text = "SCORE: " + com.example.rockpaperscissorsrpc.score.toString()

    }

}