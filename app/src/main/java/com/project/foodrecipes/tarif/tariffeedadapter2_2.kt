package com.project.foodrecipes.tarif

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.foodrecipes.R
import kotlinx.android.synthetic.main.recycler_row2.view.*
import kotlinx.android.synthetic.main.recycler_row2.view.recycler_row2_imageview as recycler_row2_imageview1



class tariffeedadapter2_2(val tariflistesi: ArrayList<tarif2>) :
    RecyclerView.Adapter<tariffeedadapter2_2.tarifHolder>() {
    private val mContext: Context? = null

    class tarifHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
    //xml ile kodu birbirine bağlama (recycler_row ile)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tarifHolder {
        val inflater1 = LayoutInflater.from(parent.context)
        val view1 = inflater1.inflate(R.layout.recycler_row2, parent, false)
        return tarifHolder(view1)
    }

    override fun onBindViewHolder(holder1: tarifHolder, position1: Int) {

        holder1.itemView.recycler_row2_kullaniciemaili.text= (tariflistesi[position1].x as CharSequence?)
        holder1.itemView.recycler_row2_tarifadi.text = tariflistesi[position1].kullaniciemaili as CharSequence?
        holder1.itemView.recycler_row2_tarifkategori.text= tariflistesi[position1].tarifadi as? CharSequence
        holder1.itemView.recycler_row2_tarifmalzemeler.text = tariflistesi[position1].tarifkategori as CharSequence?
        holder1.itemView.recycler_row2_tarifmalzemeolculeri.text= tariflistesi[position1].tarifmalzemeler as CharSequence?
        holder1.itemView.recycler_row2_tarifinstructions.text= tariflistesi[position1].tarifmalzemeolculeri as CharSequence?
        Glide
            .with(holder1.itemView.context)
            .load(tariflistesi[position1].tarifinstructions)

            .into(holder1.itemView.recycler_row2_imageview1)
    }

    override fun getItemCount(): Int {

        return tariflistesi.size
    }



}

