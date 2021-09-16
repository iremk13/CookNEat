package com.project.foodrecipes.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.foodrecipes.R
import kotlinx.android.synthetic.main.recycler_row.view.*


class feedRecyclerAdapter(val ilanlistesi: ArrayList<ilan>) :
    RecyclerView.Adapter<feedRecyclerAdapter.ilanHolder>() {

    class ilanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ilanHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row, parent, false)
        return ilanHolder(view)


    }

    override fun onBindViewHolder(holder: ilanHolder, position: Int) {
        holder.itemView.recycler_row_kullanici_email.text = ilanlistesi[position].guncelkullaniciemaili as CharSequence?
        holder.itemView.recycler_row_recipename.text = ilanlistesi[position].yemekadi as CharSequence?
        holder.itemView.recycler_row_yemekkategori.text = ilanlistesi[position].yemekkategori as CharSequence?
        holder.itemView.recycler_row_comment.text = ilanlistesi[position].yorum as CharSequence?



    }

    override fun getItemCount(): Int {

        return ilanlistesi.size
    }


}