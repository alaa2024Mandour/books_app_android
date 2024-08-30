package com.example.bookslibrary.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookslibrary.Books
import com.example.bookslibrary.R

class BooksAdapter(var books : List<Books>) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    class BooksViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var bookImage : ImageView = itemView.findViewById(R.id.card_imgView)
        var bookTitle : TextView = itemView.findViewById(R.id.book_title)
        var author : TextView = itemView.findViewById(R.id.author)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        //convert xml file to view object and sent it to view holder
        val layout = LayoutInflater.from(parent.context /*parent -> RecyclerView*/).inflate(R.layout.row_book_card, parent, false)
        return BooksViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        // bind data into views
        val book = books.get(position)
        holder.bookTitle.text = book.bookTitle
        holder.author.text = book.author
        holder.bookImage.setImageResource(book.image)
    }
}