package com.amzesmoro.businesscard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.businesscard.President
import com.amzesmoro.businesscard.R

class CardViewPresidentAdapter(private val context: Context) : RecyclerView.Adapter<PresidentViewHolder>() {

    private val presidents = mutableListOf<President>()

    fun setDataPresident(listPresident: List<President>) {
        presidents.clear()
        presidents.addAll(listPresident)
        notifyDataSetChanged()
    }

    fun getDataPresident(): List<President> {
        val presidentSequence = context.resources.getStringArray(R.array.president_sequence)
        val presidentName = context.resources.getStringArray(R.array.president_name)
        val presidentPeriod = context.resources.getStringArray(R.array.president_period)
        val presidentToo = context.resources.getStringArray(R.array.president_too)
        val presidentImage = context.resources.obtainTypedArray(R.array.president_image)

        val list = ArrayList<President>()
        for (position in presidentSequence.indices) {
            val president = President(
                presidentSequence[position],
                presidentName[position],
                presidentPeriod[position],
                presidentToo[position],
                presidentImage.getResourceId(position, 0)
            )
            list.add(president)
        }
        return list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresidentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_president, parent, false)
        return PresidentViewHolder(view)
    }

    override fun getItemCount(): Int = presidents.size

    override fun onBindViewHolder(holder: PresidentViewHolder, position: Int) {
        holder.bind(presidents[position])
    }
}