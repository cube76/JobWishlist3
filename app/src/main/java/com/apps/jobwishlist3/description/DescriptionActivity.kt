package com.apps.jobwishlist3.description

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.apps.jobwishlist3.R
import com.apps.jobwishlist3.core.domain.model.Job
import com.apps.jobwishlist3.core.utils.ConvertHtml
import com.apps.jobwishlist3.databinding.ActivityDescriptionBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DescriptionActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDescriptionBinding

    private val detailTourismViewModel: DescriptionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailTourism = intent.getParcelableExtra<Job>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailJob: Job?) {
        detailJob?.let {
            supportActionBar?.title = detailJob.title
            binding.content.tvJobType.text = detailJob.type
            binding.content.tvCompanyName.text = detailJob.company
            binding.content.tvJobTitle.text = detailJob.title
            binding.content.tvJobLocation.text = detailJob.location
            binding.content.tvDetailDescription.text = ConvertHtml(detailJob.description).fromHtml(detailJob.description)
            Glide.with(this@DescriptionActivity)
                .load(detailJob.company_logo)
                .into(binding.ivDetailImage)

            var statusFavorite = detailJob.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setWishlistJob(detailJob, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }
}
