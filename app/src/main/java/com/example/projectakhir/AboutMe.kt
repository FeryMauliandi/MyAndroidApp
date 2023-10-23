package com.example.projectakhir

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutMe : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)

        val actionBar = supportActionBar
        actionBar!!.title = "about developer"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val connectLinkedin: Button = findViewById(R.id.Linkedin)
        val connectIg: Button = findViewById(R.id.Insta)
        connectLinkedin.setOnClickListener(this)
        connectIg.setOnClickListener(this)

    }

    override fun onClick(v:View?){
        when(v?.id){
            R.id.Linkedin -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/feri-mauliandi-saputra-008976254/"))
                startActivity(intent)
            }R.id.Insta -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/feryms_/"))
                startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}