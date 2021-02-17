package com.apps.jobwishlist3.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.jobwishlist3.R
import com.apps.jobwishlist3.core.data.Resource
import com.apps.jobwishlist3.core.ui.JobAdapter
import com.apps.jobwishlist3.databinding.FragmentHomeBinding
import com.apps.jobwishlist3.description.DescriptionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val jobAdapter = JobAdapter()
            jobAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DescriptionActivity::class.java)
                intent.putExtra(DescriptionActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.job.observe(viewLifecycleOwner, { job ->
                if (job != null) {
                    when (job) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            jobAdapter.setData(job.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = job.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvJob) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = jobAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}