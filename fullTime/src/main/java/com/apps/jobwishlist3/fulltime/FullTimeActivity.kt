package com.apps.jobwishlist3.fulltime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.jobwishlist3.R
import com.apps.jobwishlist3.core.data.Resource
import com.apps.jobwishlist3.core.ui.JobAdapter
import com.apps.jobwishlist3.description.DescriptionActivity
import com.apps.jobwishlist3.di.FullTimeModuleDependencies
import com.apps.jobwishlist3.fulltime.databinding.ActivityFullTimeBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FullTimeActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val fullTimeViewModel: FullTimeViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFullTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFullTimeComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FullTimeModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFullTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Full Time"

        val jobAdapter = JobAdapter()
        jobAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DescriptionActivity::class.java)
            intent.putExtra(DescriptionActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        fullTimeViewModel.job.observe(this, { job ->
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