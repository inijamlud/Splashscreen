package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapter (private val listData: ArrayList<DBModel>): RecyclerView.Adapter<DBAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV : View): RecyclerView.ViewHolder(itemV) {
        var email: TextView = itemV.findViewById(R.id.email)
        var pass: TextView = itemV.findViewById(R.id.pass)
        var akun: TextView = itemV.findViewById(R.id.akun)
        var nama: TextView = itemV.findViewById(R.id.nama)
        var btn_update: Button = itemV.findViewById(R.id.btn_update)
        var btn_delete: Button = itemV.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val data = listData[position]
        holder.email.text = data.email
        holder.pass.text = data.pass
        holder.akun.text = data.username
        holder.nama.text = data.fullname

        holder.btn_delete.setOnClickListener {
            var adapterDBHelper: DBHelper
            adapterDBHelper = DBHelper(holder.itemView.context)
            adapterDBHelper.deleteData(data.email)
            listData.removeAt(position)
            notifyDataSetChanged()
        }

        holder.btn_update.setOnClickListener {
            val intentUpd = Intent(holder.itemView.context, UpdateActivity::class.java)
            val bundle = Bundle()
            bundle.putString("email", data.email)
            bundle.putString("username", data.username)
            bundle.putString("pass", data.pass)
            bundle.putString("fullname", data.fullname)
            bundle.putString("email", data.email)
            bundle.putString("phone", data.phone)
            bundle.putString("gender", data.gender)

            intentUpd.putExtras(bundle)
            holder.itemView.context.startActivity(intentUpd)

        }
    }

}