package com.example.atlas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.atlas.adapters.NewsAdapter
import com.example.atlas.databinding.FragmentNewsListBinding
import com.example.atlas.utilities.InjectorUtils
import com.example.atlas.viewmodels.NewsListViewModel

class NewsListFragment : Fragment() {

    private val viewModel: NewsListViewModel by viewModels {
        InjectorUtils.provideNewsListViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewsListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = NewsAdapter()
        binding.newsList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: NewsAdapter) {
        viewModel.newsList.observe(viewLifecycleOwner) { news ->
            if (news != null) adapter.submitList(news)
        }
    }
}
