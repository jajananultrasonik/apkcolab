package com.example.videoprocessor

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var videoEditText: EditText
    private lateinit var mp3EditText: EditText
    private lateinit var textAtasEditText: EditText
    private lateinit var textBawahEditText: EditText
    private lateinit var durasiEditText: EditText
    private lateinit var splitCheckBox: CheckBox
    private lateinit var prosesButton: Button

    private val PICK_VIDEO = 1
    private val PICK_AUDIO = 2

    private var videoUri: Uri? = null
    private var audioUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoEditText = findViewById(R.id.editVideo)
        mp3EditText = findViewById(R.id.editMp3)
        textAtasEditText = findViewById(R.id.editTextAtas)
        textBawahEditText = findViewById(R.id.editTextBawah)
        durasiEditText = findViewById(R.id.editDurasi)
        splitCheckBox = findViewById(R.id.checkSplit)
        prosesButton = findViewById(R.id.buttonProses)

        videoEditText.setOnClickListener { pickFile(PICK_VIDEO) }
        mp3EditText.setOnClickListener { pickFile(PICK_AUDIO) }

        prosesButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("videoUri", videoUri?.toString())
            intent.putExtra("audioUri", audioUri?.toString())
            intent.putExtra("textAtas", textAtasEditText.text.toString())
            intent.putExtra("textBawah", textBawahEditText.text.toString())
            intent.putExtra("durasi", durasiEditText.text.toString())
            intent.putExtra("split", splitCheckBox.isChecked)
            startActivity(intent)
        }
    }

    private fun pickFile(requestCode: Int) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = if (requestCode == PICK_VIDEO) "video/*" else "audio/*"
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            val uri: Uri? = data.data
            when (requestCode) {
                PICK_VIDEO -> {
                    videoUri = uri
                    videoEditText.setText(uri.toString())
                }
                PICK_AUDIO -> {
                    audioUri = uri
                    mp3EditText.setText(uri.toString())
                }
            }
        }
    }
}