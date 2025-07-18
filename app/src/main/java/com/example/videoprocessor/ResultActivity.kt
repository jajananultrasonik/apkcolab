package com.example.videoprocessor

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button
    private lateinit var preview: ImageView // Ganti VideoView jika ingin preview video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        preview = findViewById(R.id.videoResult)
        saveButton = findViewById(R.id.buttonSave)
        deleteButton = findViewById(R.id.buttonDelete)

        saveButton.setOnClickListener {
            Toast.makeText(this, "Video Disimpan!", Toast.LENGTH_SHORT).show()
        }
        deleteButton.setOnClickListener {
            Toast.makeText(this, "Video Dihapus!", Toast.LENGTH_SHORT).show()
        }
    }
}