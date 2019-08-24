package com.example.rock_paper_scissors_samin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import java.util.Random

class GameActivity : AppCompatActivity() {

    lateinit var rockButton: Button
    lateinit var paperButton: Button
    lateinit var scissorsButton: Button
    lateinit var user1Image: ImageView
    lateinit var user2Image: ImageView
    lateinit var scoreView: TextView
    lateinit var mode: String
    var activePlayer = 1
    var user1Choice = 0
    var userScore = 0
    var comScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        rockButton = findViewById(R.id.rockButton) as Button
        paperButton = findViewById(R.id.paperButton) as Button
        scissorsButton = findViewById(R.id.scissorsButton) as Button
        user1Image = findViewById(R.id.user1Image) as ImageView
        user2Image = findViewById(R.id.user2Image) as ImageView
        scoreView = findViewById(R.id.scoreView) as TextView
        mode = intent.getStringExtra("mode")

        if(mode == "dual"){
            var textBox: TextView = findViewById(R.id.secondPlayer)
            textBox.setText("2nd Player")
        }

        if(mode == "single") {
            rockButton.setOnClickListener {
                user1Image.setImageResource(R.drawable.rock)
                val res = Play(0)
                Toast.makeText(this@GameActivity, res, Toast.LENGTH_SHORT).show()
                scoreView.text = Integer.toString(userScore) + " - " + Integer.toString(comScore)
            }

            paperButton.setOnClickListener {
                user1Image.setImageResource(R.drawable.paper)
                val res = Play(1)
                Toast.makeText(this@GameActivity, res, Toast.LENGTH_SHORT).show()
                scoreView.text = Integer.toString(userScore) + " - " + Integer.toString(comScore)
            }

            scissorsButton.setOnClickListener {
                user1Image.setImageResource(R.drawable.scissors)
                val res = Play(2)
                Toast.makeText(this@GameActivity, res, Toast.LENGTH_SHORT).show()
                scoreView.text = Integer.toString(userScore) + " - " + Integer.toString(comScore)
            }
        }

        else if(mode == "dual"){

            rockButton.setOnClickListener {
                if(activePlayer == 1) {
                    user1Image.visibility = View.INVISIBLE
                    user2Image.visibility = View.INVISIBLE
                    activePlayer = 2
                    user1Choice = 0
                    Toast.makeText(this@GameActivity, "Player 2", Toast.LENGTH_SHORT).show()
                }
                else if(activePlayer == 2) {
                    activePlayer = 1
                    val res = Play(user1Choice, 0)
                    Toast.makeText(this@GameActivity, res, Toast.LENGTH_SHORT).show()
                    scoreView.text = Integer.toString(userScore) + " - " + Integer.toString(comScore)
                }
            }

            paperButton.setOnClickListener {
                if (activePlayer == 1) {
                    user1Image.visibility = View.INVISIBLE
                    user2Image.visibility = View.INVISIBLE
                    activePlayer = 2
                    user1Choice = 1
                    Toast.makeText(this@GameActivity, "Player 2", Toast.LENGTH_SHORT).show()
                }
                else if (activePlayer == 2) {
                    activePlayer = 1
                    val res = Play(user1Choice, 1)
                    Toast.makeText(this@GameActivity, res, Toast.LENGTH_SHORT).show()
                    scoreView.text = Integer.toString(userScore) + " - " + Integer.toString(comScore)
                }
            }

            scissorsButton.setOnClickListener {
                if (activePlayer == 1) {
                    user1Image.visibility = View.INVISIBLE
                    user2Image.visibility = View.INVISIBLE
                    activePlayer = 2
                    user1Choice = 2
                    Toast.makeText(this@GameActivity, "Player 2", Toast.LENGTH_SHORT).show()
                }
                else if (activePlayer == 2) {
                    activePlayer = 1
                    val res = Play(user1Choice, 2)
                    Toast.makeText(this@GameActivity, res, Toast.LENGTH_SHORT).show()
                    scoreView.text = Integer.toString(userScore) + " - " + Integer.toString(comScore)
                }
            }
        }
    }

    fun Play(userChoice: Int): String {
        user1Image.visibility = View.VISIBLE
        user2Image.visibility = View.VISIBLE

        val random = Random()
        val com = random.nextInt(3)

        if (com == 0) {
            user2Image.setImageResource(R.drawable.rock)
        } else if (com == 1) {
            user2Image.setImageResource(R.drawable.paper)
        } else {
            user2Image.setImageResource(R.drawable.scissors)
        }

        if (userChoice == com) {
            return "It's a draw!"
        } else if (userChoice == 0) {
            if (com == 1) {
                comScore++
                return "Paper covers Rock. Computer wins!"
            } else {
                userScore++
                return "Rock crushes Scissors. You win!"
            }
        } else if (userChoice == 1) {
            if (com == 0) {
                userScore++
                return "Paper covers Rock. You win!"
            } else {
                comScore++
                return "Scissors cuts Paper. Computer wins!"
            }
        } else if (userChoice == 2) {
            if (com == 0) {
                comScore++
                return "Rock crushes Scissors. Computer wins!"
            } else {
                userScore++
                return "Scissors cuts Paper. You win!"
            }
        } else
            return "Unsure"
    }

    fun Play(user1Choice: Int, user2Choice: Int): String {
        user1Image.visibility = View.VISIBLE
        user2Image.visibility = View.VISIBLE

        if (user1Choice == 0) {
            user1Image.setImageResource(R.drawable.rock)
        } else if (user1Choice == 1) {
            user1Image.setImageResource(R.drawable.paper)
        } else {
            user1Image.setImageResource(R.drawable.scissors)
        }

        if (user2Choice == 0) {
            user2Image.setImageResource(R.drawable.rock)
        } else if (user2Choice == 1) {
            user2Image.setImageResource(R.drawable.paper)
        } else {
            user2Image.setImageResource(R.drawable.scissors)
        }

        if (user1Choice == user2Choice) {
            return "It's a draw!"
        } else if (user1Choice == 0) {
            if (user2Choice == 1) {
                comScore++
                return "Paper covers Rock. Player 2 wins!"
            } else {
                userScore++
                return "Rock crushes Scissors. Player 1 win!"
            }
        } else if (user1Choice == 1) {
            if (user2Choice == 0) {
                userScore++
                return "Paper covers Rock. Player 1 win!"
            } else {
                comScore++
                return "Scissors cuts Paper. Player 2 wins!"
            }
        } else if (user1Choice == 2) {
            if (user2Choice == 0) {
                comScore++
                return "Rock crushes Scissors. Player 2 wins!"
            } else {
                userScore++
                return "Scissors cuts Paper. Player 1 win!"
            }
        } else
            return "Unsure"
    }
}

