package com.example.flowproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flowproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLiveData.setOnClickListener {
            viewModel.triggerLiveDate()
        }

        binding.btnStateFlow.setOnClickListener {
            viewModel.triggerStateFlow()
        }

        binding.btnFlow.setOnClickListener {
            viewModel.triggerFlow()
        }

        binding.btnShareteFlow.setOnClickListener {
            viewModel.triggerSharedFlow()
        }
        subscribeToObservables()
    }

    private fun subscribeToObservables(){
        viewModel.liveData.observe(this){
            binding.txtLiveData.text = it
        }
    }}