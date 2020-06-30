package com.cybernerd.todo.db

class SubscriberRespository(private val dao: SubscriberDao) {
    val subscribers = dao.getAllSubscriber()
    suspend fun insert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        dao.deleteall()
    }
}