package com.will.ContactMe

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.will.ContactMe.DetailActivity.Companion.EXTRA_CONTACT


class MainActivity : AppCompatActivity(), ClickItemContactListener {

    //recycle view component
    private  val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        fetchListContact()
        bindViews()

    }
    private fun fetchListContact() {
        val list = arrayListOf(
            Contact(
                "Silvester Stallone",
                "(00) 0000-0000",
                "img.png"
            ),
            Contact(
                "Arnold Schwarzenegger",
                "(99) 9999-9999",
                "img.png"
            ),
            Contact(
                "Chuck Norris",
                "(00) 0000-0000",
                "img.png"
            )

        )
        getInstanceSharedPreferences().edit {
            val json = Gson().toJson(list)
            putString("contacts", json)
            commit()
        }
    }

    //to obtain instances
    private fun getInstanceSharedPreferences(): SharedPreferences{
        return getSharedPreferences("com.will.ContactMe.PREFERENCES", Context.MODE_PRIVATE)
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }
    //convert string to class object
    private fun getListContacts() : List<Contact>{
        val list = getInstanceSharedPreferences().getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }
    private fun updateList() {
        val list = getListContacts()
        adapter.updateList(list)
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    //create menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.item_menu1 -> {
                showToast("Item 1")
                return true
            }
            R.id.item_menu2 -> {
                showToast("Item 2")
                return true
            }
            R.id.item_menu3 -> {
                showToast("Item 3")
                return true
            }
            R.id.item_menu4 -> {
                showToast("Item 4")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT,contact)
        startActivity(intent)
    }

}