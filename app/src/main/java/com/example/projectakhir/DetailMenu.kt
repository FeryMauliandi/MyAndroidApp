package com.example.projectakhir

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMenu : AppCompatActivity() {
    companion object{
        const val EXTRA_TITLE = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_PRICE = "extra_price"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_detail)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Menu"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvDesc: TextView = findViewById(R.id.tv_item_description)
        val tvPrice: TextView = findViewById(R.id.price)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val price = intent.getStringExtra(EXTRA_PRICE)

        tvDesc.text = desc
        tvName.text = title
        Glide.with(this)
            .load(photo)
            .apply(RequestOptions())
            .into(imgPhoto)
        tvPrice.text = price

        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener{
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Bagikan ke temanmu")
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui:"))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

}