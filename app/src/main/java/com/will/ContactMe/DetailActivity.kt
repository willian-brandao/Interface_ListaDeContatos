package com.will.ContactMe

import android.os.Bundle
import android.widget.TextView


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity: AppCompatActivity() {

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }
    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //create button to back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    //get data
    private fun getExtras() {
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }
    //set data on view
    private fun bindViews() {
        findViewById<TextView>(R.id.tv_name).text = contact?.name
        findViewById<TextView>(R.id.tv_phone).text = contact?.phone
    }
    //create key
   companion object {
       const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
   }
    //implements the button back on detail's element's page
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}