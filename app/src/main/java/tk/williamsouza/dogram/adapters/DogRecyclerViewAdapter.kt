package tk.williamsouza.dogram.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tk.williamsouza.dogram.R
import tk.williamsouza.dogram.models.Dog

class DogRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<Dog> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DogsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dogs_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is DogsViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(dogsList : List<Dog>) {
        items = dogsList
    }

    class DogsViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val dogImage = itemView.findViewById<ImageView>(R.id.dogImage)

        fun bind(dog : Dog) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(dog.message)
                .into(dogImage)
        }

    }
}