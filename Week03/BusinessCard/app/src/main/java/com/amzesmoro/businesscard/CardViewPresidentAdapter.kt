package com.amzesmoro.businesscard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_president.view.*

class CardViewPresidentAdapter(private val listPresident: ArrayList<President>)
    : RecyclerView.Adapter<CardViewPresidentAdapter.PresidentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresidentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_president, parent, false)
        return PresidentViewHolder(view)
    }

    override fun getItemCount(): Int = listPresident.size

    override fun onBindViewHolder(holder: PresidentViewHolder, position: Int) {
        holder.bind(listPresident[position])
    }

    inner class PresidentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(president: President) {
            with(itemView) {
                sequenceOfPresidentTv.text = president.presidentSequence
                nameOfPresidentTv.text = president.presidentName
                periodOfPresidentTv.text = president.presidentPeriod
                tooOfPresidentTv.text = president.presidentTermOfOfice
                Glide.with(itemView.context)
                    .load(president.presidentPhoto)
                    .placeholder(R.drawable.ic_baseline_account_box)
                    .into(presidentImg)

                shareBtn.setOnClickListener {
                    val message = "${nameOfPresidentTv.text} " + context.getString(R.string.tobe_is) +
                            " ${sequenceOfPresidentTv.text} " + context.getString(R.string.of_indonesia) +
                            " ${periodOfPresidentTv.text} " + context.getString(R.string.term_of_office) +
                            " ${tooOfPresidentTv.text}"
                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.putExtra(Intent.EXTRA_TEXT, message)
                    shareIntent.type = "text/plain"

                    context.startActivity(Intent.createChooser(shareIntent, context.getString(R.string.share_to)))
                }
            }
        }
    }
}