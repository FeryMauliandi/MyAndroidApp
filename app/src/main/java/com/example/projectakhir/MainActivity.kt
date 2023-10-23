package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMenu: RecyclerView
    private var list = ArrayList<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMenu = findViewById(R.id.rv_menu)
        rvMenu.setHasFixedSize(true)

        list.addAll(getListMenu())
        showRecyclerList()
    }
    
    private fun getListMenu(): ArrayList<Menu> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMenu = ArrayList<Menu>()
        for (i in dataName.indices) {
            val menu = Menu(dataName[i], dataDescription[i], dataPrice[i] ,dataPhoto.getResourceId(i, -1))
            listMenu.add(menu)
        }
        return listMenu
    }

    private fun showRecyclerList() {
        rvMenu.layoutManager = LinearLayoutManager(this)
        val listMenuAdapter = ListMenuAdapter(list)
        rvMenu.adapter = listMenuAdapter

}

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.my_profile -> {
                val profile = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(profile)
            }
        }
       return super.onOptionsItemSelected(item)
    }
}