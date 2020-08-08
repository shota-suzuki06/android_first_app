package com.example.android_first_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.android_first_app.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

// intentからmessageを取り出すためのkey
const val EXTRA_MESSAGE = "com.example.android_first_app"

private lateinit var binding: ActivityMainBinding

// Activityとlayout.xmlは対になっている
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView を 下記の記述に置き換える
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, binding.editText.text.toString())
            }
            startActivity(intent)
        }
    }

    // DataBindingを使用しない例
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
