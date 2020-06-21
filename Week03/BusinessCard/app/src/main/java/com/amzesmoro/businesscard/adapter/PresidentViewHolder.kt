package com.amzesmoro.businesscard.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amzesmoro.businesscard.President
import com.amzesmoro.businesscard.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_president.view.*

class PresidentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(president: President) {
        with(itemView) {
            sequenceOfPresidentTv.text = president.presidentSequence
            nameOfPresidentTv.text = president.presidentName
            periodOfPresidentTv.text = president.presidentPeriod
            tooOfPresidentTv.text = president.presidentTermOfOffice
            Glide.with(itemView.context)
                .load(president.presidentPhoto)
                .placeholder(R.drawable.ic_baseline_account_box)
                .into(presidentImg)

            shareBtn.setOnClickListener {
                val message = "${nameOfPresidentTv.text} " + context.getString(
                    R.string.tobe_is
                ) +
                        " ${sequenceOfPresidentTv.text} " + context.getString(R.string.of_indonesia) +
                        " ${periodOfPresidentTv.text} " + context.getString(R.string.term_of_office) +
                        " ${tooOfPresidentTv.text}"

                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, message)
                    type = "text/plain"
                }
                context.startActivity(
                    Intent.createChooser(shareIntent, context.getString(
                    R.string.share_to
                )))
            }
        }
    }
}