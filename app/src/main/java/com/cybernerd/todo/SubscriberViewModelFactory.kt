package com.cybernerd.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.todo.db.SubscriberRespository
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repository: SubscriberRespository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return SubscriberViewModel(repository) as T

        }
            throw IllegalArgumentException("Unknow View model class")
    }

}