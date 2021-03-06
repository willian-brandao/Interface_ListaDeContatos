package com.will.ContactMe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//pass the class listener as parameter to use on methods
class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //class attribute to store the list
    private val list: MutableList<Contact> = mutableListOf()

    //create view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view,list,listener)
    }
    //count the elements of list
    override fun getItemCount(): Int {
        return list.size
    }
    //read the list's item and bind the item on recycleView's list
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
       holder.bind(list[position])
    }
    //method to access the adapter and repass the list into adapter
    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    class ContactAdapterViewHolder (itemView: View, var list: List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder( itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private  val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)

        //create click to show details on elements
        init {
            itemView.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind( contact: Contact){
           tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }

}