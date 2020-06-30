package com.cybernerd.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.todo.databinding.ActivityMainBinding
import com.cybernerd.todo.db.SubscriberDatabase
import com.cybernerd.todo.db.SubscriberRespository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDao

        val respository = SubscriberRespository(dao)
        val factory = SubscriberViewModel(respository)

        subscriberViewModel = ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)

        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this



    }

    private fun displaySubscribersList(){

    }
}
