package com.shobhit97.countryapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shobhit97.countryapp.R
import com.shobhit97.countryapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityMainBinding
    private val binding get() = _binding
    private lateinit var countryAdapter:CountryAdapter

    val viewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryAdapter = CountryAdapter()
        binding.rv.apply {
            adapter = countryAdapter
            setHasFixedSize(true)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                launch{
                    viewModel.getAllCountries().collect{
                        it.let {
                            countryAdapter.submitList(it)
                        }

                    }
                }
            }
        }

    }
}