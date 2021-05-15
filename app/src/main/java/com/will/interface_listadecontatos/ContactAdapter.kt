package com.will.interface_listadecontatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //class attribute to store the list
    private val list: MutableList<Contact> = mutableListOf()

    //create view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }
    //count the elements of list
    override fun getItemCount(): Int {
        return list.size
    }
    //read the list's item and bind the item on recycleView's list
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
       holder.bind(list[position])
    }

    class ContactAdapterViewHolder (itemView: View) : RecyclerView.ViewHolder( itemView) {
        fun bind( contact: Contact){

        }
    }

}