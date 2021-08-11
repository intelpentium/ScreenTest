package ezlink.project.screentest.Adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ezlink.project.screentest.Model.GenreItem
import ezlink.project.screentest.R
import ezlink.project.screentest.View.Movie
import kotlinx.android.synthetic.main.genre_item.view.*

class GenreAdapter (var genre: List<GenreItem?>?) : RecyclerView.Adapter<GenreAdapter.genreHolder>() {
    class genreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.name
        val cardview = itemView.cardview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): genreHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
        val holder = genreHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return genre?.size ?: 0
    }

    override fun onBindViewHolder(holder: genreHolder, position: Int) {
        val all = genre?.get(position)
        holder.name.text = all?.name
        holder.cardview.setOnClickListener {

            val intent = Intent(holder.itemView.context, Movie::class.java)
            intent.putExtra("id", all?.id)
            holder.itemView.context.startActivity(intent)
        }
    }
}