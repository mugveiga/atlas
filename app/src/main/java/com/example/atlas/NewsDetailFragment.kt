package com.example.atlas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.atlas.databinding.FragmentNewsDetailBinding
import kotlinx.android.synthetic.main.fragment_news_detail.*


class NewsDetailFragment : Fragment() {

    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentNewsDetailBinding>(
            inflater, R.layout.fragment_news_detail, container, false
        ).apply {
            news = args.news
            lifecycleOwner = this@NewsDetailFragment
            fab.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(news!!.url)
                startActivity(i)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }
}
