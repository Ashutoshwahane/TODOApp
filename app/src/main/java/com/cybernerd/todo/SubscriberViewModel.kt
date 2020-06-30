package com.cybernerd.todo

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybernerd.todo.db.Subscriber
import com.cybernerd.todo.db.SubscriberRespository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository : SubscriberRespository): ViewModel() {

    val subscriber = repository.subscribers

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButton = MutableLiveData<String>()

    @Bindable
    val clearAllOrDelete = MutableLiveData<String>()

    init {
        saveOrUpdateButton.value = "Save"
        clearAllOrDelete.value = "Clear All"
    }

    fun saveOrUpdate(){
        val name : String = inputName.value!!
        val email: String = inputEmail.value!!
        insert(Subscriber(0,name, email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearOrDelete(){
        clearAll()
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }


}