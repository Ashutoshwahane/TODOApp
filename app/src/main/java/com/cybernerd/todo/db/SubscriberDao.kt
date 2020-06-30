package com.cybernerd.todo.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SubscriberDao {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber")
    suspend fun deleteall()

    @Query("SELECT * FROM subscriber")
    fun getAllSubscriber(): LiveData<List<Subscriber>>
}