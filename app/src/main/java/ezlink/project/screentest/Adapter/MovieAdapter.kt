package ezlink.project.screentest.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ezlink.project.screentest.Helper.Config
import ezlink.project.screentest.Model.MovieItem
import ezlink.project.screentest.R
import ezlink.project.screentest.View.MovieDetail
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (var moview: List<MovieItem?>?) : RecyclerView.Adapter<MovieAdapter.moviewHolder>() {

    class moviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val release_date = itemView.release_date
        val overview = itemView.overview
        val vote_count = itemView.vote_count
        val vote_average = itemView.vote_average
        val poster_path = itemView.poster_path
        val cardview = itemView.cardview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): moviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        val holder = moviewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return moview?.size ?: 0
    }

    override fun onBindViewHolder(holder: moviewHolder, position: Int) {
        val all = moview?.get(position)

        holder.title.text = all?.title
        holder.release_date.text = all?.releaseDate
        holder.overview.text = all?.overview
        holder.vote_count.text = "Total Rating : "+all?.voteAverage.toString()
        holder.vote_average.text = "Reviews :"+all?.voteCount.toString()

        Glide.with(holder.itemView.context).load(Config.URL_IMAGE+""+all?.posterPath).into(holder.poster_path)

        holder.cardview.setOnClickListener {

            val intent = Intent(holder.itemView.context, MovieDetail::class.java)
            intent.putExtra("id", all?.id)
            holder.itemView.context.startActivity(intent)
        }
    }
}