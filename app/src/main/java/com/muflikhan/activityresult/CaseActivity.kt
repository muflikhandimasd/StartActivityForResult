package com.muflikhan.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muflikhan.activityresult.databinding.ActivityCaseBinding

class CaseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val message = binding.editMsg.text.toString()
            val intent = Intent()
            intent.putExtra("msg", message)
            setResult(200, intent)
            finish()
        }
    }
}