package com.example.rock_paper_scissors_samin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var singlePlaterBtn: Button
    lateinit var dualPlaterBtn: Button
    lateinit var rules: Button
    lateinit var exit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singlePlaterBtn = findViewById(R.id.singlePlayer)
        dualPlaterBtn = findViewById(R.id.dualPlayer)
        rules = findViewById(R.id.rules)
        exit = findViewById(R.id.exit)

        singlePlaterBtn.setOnClickListener {
            var intent =  Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("mode", "single")
            startActivity(intent)
        }

        dualPlaterBtn.setOnClickListener {
            var intent =  Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("mode", "dual")
            startActivity(intent)
        }

        rules.setOnClickListener {
            var intent =  Intent(this@MainActivity, RulesActivity::class.java)
            startActivity(intent)
        }

        exit.setOnClickListener {
            exitProcess(0)
        }
    }
}
