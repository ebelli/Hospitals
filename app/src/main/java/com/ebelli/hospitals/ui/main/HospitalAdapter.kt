package com.ebelli.hospitals.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ebelli.hospitals.R
import com.ebelli.hospitals.data.entities.HospitalEntity
import com.ebelli.hospitals.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_list_hospital.view.*

const val HOSPITAL_EXTRA = "HOSPITAL"

class HospitalAdapter: RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {


    private lateinit var hospitals: List<HospitalEntity>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val repoView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_hospital, parent, false) as LinearLayout

        return HospitalViewHolder(repoView)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(hospitals[position])
    }

    override fun getItemCount(): Int = hospitals.size

    fun setData(hospitals: List<HospitalEntity>) {
        this.hospitals = hospitals
    }

    class HospitalViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(hospital: HospitalEntity) = with(view) {
            hospital_name.text = hospital.organisationName
            hospital_city.text = hospital.city

            itemView.setOnClickListener{ openDetails(hospital, itemView) }
        }

        private fun openAlbum(url: String, view: View) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, url)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(view.context, shareIntent, null)
        }

        private fun openDetails(album: HospitalEntity, view: View) {
            val intent = Intent(view.context, DetailActivity::class.java)
                .apply {
                    putExtra(HOSPITAL_EXTRA, album)
                }
            startActivity(view.context, intent, null)
        }
    }
}