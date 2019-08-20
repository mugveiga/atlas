package com.example.atlas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.atlas.NewsListFragmentDirections
import com.example.atlas.data.News
import com.example.atlas.databinding.ListItemNewsBinding

/**
 * Adapter for the [RecyclerView] in [NewsListFragment].
 */
class NewsAdapter : ListAdapter<News, NewsAdapter.ViewHolder>(NewsDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = getItem(position)
        holder.apply {
            bind(createOnClickListener(news), news)
            itemView.tag = news
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    private fun createOnClickListener(news: News): View.OnClickListener {
        return View.OnClickListener {
            val direction = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(news)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: News) {
            binding.apply {
                clickListener = listener
                news = item
                executePendingBindings()
            }
        }
    }
}

private class NewsDiffCallback : DiffUtil.ItemCallback<News>() {

    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}
