package com.example.projetkotlin.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import com.example.projetkotlin.presentation.credits.Credits
import com.example.projetkotlin.presentation.list.ListActivity
import com.example.projetkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      main_button.setOnClickListener{
          mainViewModel.onClickedIncrement()
      }

     mainViewModel.counter.observe(this, Observer {
        value -> main_text.text = value.toString()
     })

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, Credits::class.java)
            startActivity(intent)
        }

    }

}