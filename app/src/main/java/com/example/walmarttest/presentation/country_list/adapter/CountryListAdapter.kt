package com.example.walmarttest.presentation.country_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmarttest.databinding.AdapterCountryItemBinding
import com.example.walmarttest.domain.dto.Country

class CountryListAdapter():RecyclerView.Adapter<MyViewHolder>() {

    private var countries: List<Country> = emptyList()

    fun setCountries(countries: List<Country>) {
        this.countries = countries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = AdapterCountryItemBinding.inflate(inflator, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}

class MyViewHolder(val binding:AdapterCountryItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(country:Country) {
        binding.tvNameRegion.text = "${country.name}, ${country.region}"
        binding.tvCode.text = country.code
        binding.tvCapital.text = country.capital
    }

}