package com.shobhit97.countryapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shobhit97.countryapp.R
import com.shobhit97.countryapp.databinding.ListItemBinding
import com.shobhit97.countryapp.domain.model.Country

class CountryAdapter:ListAdapter<Country, CountryAdapter.ViewHolder>(DIFF_UTIL) {

    inner class ViewHolder(private val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindData(country: Country) {
            binding.countryName.text = country.countries_name
            binding.countryCode.text = country.country_code
            Glide.with(binding.root)
                .load(country.flag)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.flag)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
                 return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem.countries_id == newItem.countries_id
            }

        }
    }
}