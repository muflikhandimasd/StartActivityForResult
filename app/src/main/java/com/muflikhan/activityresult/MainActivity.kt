package com.muflikhan.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.muflikhan.activityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Cara Baru
        val resultRelaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            result -> if (result.resultCode == 200){
                val message = result.data
            val name = message?.getStringExtra("msg")
            binding.tvResult.text = name
        }
        }

        binding.btnGo.setOnClickListener{
            val intent = Intent(this, CaseActivity::class.java)
//            cara lama
//            startActivityForResult(intent, 100)

//            Cara Baru
            resultRelaunch.launch(intent)
        }
    }

//    TUTORIAL AWAL
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 100){
//            if (resultCode == 200){
//                val message = data?.getStringExtra("msg")
//                binding.tvResult.text = message
//            }
//        }
//    }
}