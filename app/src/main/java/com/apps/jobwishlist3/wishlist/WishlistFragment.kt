package com.apps.jobwishlist3.wishlist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.jobwishlist3.core.ui.JobAdapter
import com.apps.jobwishlist3.databinding.FragmentWishlistBinding
import com.apps.jobwishlist3.description.DescriptionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WishlistFragment : Fragment() {

    private val favoriteViewModel: WishlistViewModel by viewModels()

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
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

            favoriteViewModel.wishlistJob.observe(viewLifecycleOwner, { dataTourism ->
                jobAdapter.setData(dataTourism)
                binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTourism) {
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