package com.ebelli.hospitals.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebelli.hospitals.R
import com.ebelli.hospitals.utils.Resource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()
    private val hospitalAdapter = HospitalAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        setupObservers()
        mainViewModel.getHospitals()
    }

    private fun initRecyclerView() {
        val recyclerView = hospital_list
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        with(recyclerView) {
            layoutManager = viewManager
            adapter = hospitalAdapter
        }
    }

    private fun setupObservers() {
        mainViewModel.hospitals.observe(this, Observer {
            it?.let { result ->
                when (result) {
                    is Resource.Loading -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Error -> {
                        progressBar.visibility = View.GONE
                        it.message?.let { message ->
                            val snackbar = Snackbar.make(
                                root,
                                message, Snackbar.LENGTH_LONG
                            )
                            snackbar.show()
                        }
                    }
                    is Resource.Success -> {
                        it.data?.let {hospitals ->
                            hospitalAdapter.setData(hospitals)
                            hospitalAdapter.notifyDataSetChanged()
                            hospital_list.visibility = View.VISIBLE
                        }
                        progressBar.visibility = View.GONE
                    }
                }
            }
        })
    }
}