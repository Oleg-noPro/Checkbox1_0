package com.example.checkbox1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textET: EditText
    private lateinit var textTV: TextView

    private lateinit var saveTextBTN: Button
    private lateinit var deleteTextBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textET = findViewById(R.id.textET)
        textTV = findViewById(R.id.textTV)

        saveTextBTN = findViewById(R.id.saveTextBTN)
        deleteTextBTN = findViewById(R.id.deleteTextBTN)


        saveTextBTN.setOnClickListener(this)
        deleteTextBTN.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        val editText = textET.text.toString()
        when (v.id) {
            R.id.saveTextBTN -> textTV.text = editText
            R.id.deleteTextBTN -> {
                Snackbar
                    .make(v, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                    .setAction("Удалить") {
                        textTV.text = ""
                        Snackbar.make(v, "Данные удалены", Snackbar.LENGTH_LONG).show()
                    }.show()
            }
        }

    }

}