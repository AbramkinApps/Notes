package com.abramkinapps.android.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abramkinapps.android.notes.model.AppNote
import com.abramkinapps.android.notes.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application):AndroidViewModel(application) {
    fun insert(note: AppNote, onSuccess:()->Unit) =
        viewModelScope.launch ( Dispatchers.Main ){
            REPOSITORY.insert(note){
                onSuccess()
            }
        }
}