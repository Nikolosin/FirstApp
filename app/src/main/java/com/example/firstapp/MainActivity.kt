package com.example.firstapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var post = Post(
            "14 августа 2021",
            "Nikolay Petrenko",
            "First post in our network!",
            15, 10, 0
        )
        val data: TextView = findViewById(R.id.data)
        data.text = post.data
        val name: TextView = findViewById(R.id.name)
        name.text = post.name
        val text: TextView = findViewById(R.id.textPost)
        text.text = post.text
        var itemLike: TextView = findViewById(R.id.itemLike)
        itemLike.text = post.itemLike.toString()
        var itemCom: TextView = findViewById(R.id.itemComment)
        itemCom.text = post.itemComm.toString()
        var itemShare: TextView = findViewById(R.id.itemShare)
        itemShare.text = post.itemShare.toString()
        val btnLike: ImageButton = findViewById(R.id.buttonLike)

        zeroItem(itemLike, post.itemLike)
        zeroItem(itemCom, post.itemComm)
        zeroItem(itemShare, post.itemShare)
        btnLike.setOnClickListener {
            if (post.activeLike) {
                btnLike.setImageResource(R.drawable.ic_baseline_favorite_24)
                post.itemLike -= 1
                itemLike.text = (post.itemLike).toString()
                itemLike.setTextColor(Color.GRAY);
                post.activeLike = false
            } else {
                btnLike.setImageResource(R.drawable.ic_baseline_favoritered_24)
                post.itemLike += 1
                itemLike.text = (post.itemLike).toString()
                itemLike.setTextColor(Color.RED);
                post.activeLike = true
            }
            zeroItem(itemLike, post.itemLike)
        }
        val btnCom: ImageButton = findViewById(R.id.buttonComment)
        btnCom.setOnClickListener {
            if (post.activeComm) {
                btnCom.setImageResource(R.drawable.ic_baseline_comment_24)
                post.itemComm -= 1
                itemCom.text = (post.itemComm).toString()
                itemCom.setTextColor(Color.GRAY);
                post.activeComm = false
            } else {
                btnCom.setImageResource(R.drawable.ic_baseline_commentred_24)
                post.itemComm += 1
                itemCom.text = (post.itemComm).toString()
                itemCom.setTextColor(Color.RED);
                post.activeComm = true
            }
            zeroItem(itemCom, post.itemComm)
        }
        val btnShare: ImageButton = findViewById(R.id.buttonShare)
        btnShare.setOnClickListener {
            if (post.activeShare) {
                btnShare.setImageResource(R.drawable.ic_baseline_share_24)
                post.itemShare -= 1
                itemShare.text = (post.itemShare).toString()
                itemShare.setTextColor(Color.GRAY);
                post.activeShare = false
            } else {
                btnShare.setImageResource(R.drawable.ic_baseline_sharered_24r)
                post.itemShare += 1
                itemShare.text = (post.itemShare).toString()
                itemShare.setTextColor(Color.RED);
                post.activeShare = true
            }
            zeroItem(itemShare, post.itemShare)
        }
    }

    fun zeroItem (textView: TextView, int: Int) {
        if (int == 0) textView.setVisibility(View.GONE)
        else textView.setVisibility(View.VISIBLE)

    }
}