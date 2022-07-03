package com.abramkinapps.android.notes.database

import androidx.lifecycle.LiveData
import androidx.paging.RemoteMediator
import com.abramkinapps.android.notes.model.AppNote

interface DatabaseRepository {

    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note: AppNote, onSuccess:()->Unit)
    suspend fun delete(note: AppNote, onSuccess:()->Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}

    fun signOut(){}

}