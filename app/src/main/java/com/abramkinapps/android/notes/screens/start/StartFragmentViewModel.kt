package com.abramkinapps.android.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.RemoteMediator
import com.abramkinapps.android.notes.database.firebase.AppFirebaseRepository
import com.abramkinapps.android.notes.database.room.AppRoomDatabase
import com.abramkinapps.android.notes.database.room.AppRoomRepository
import com.abramkinapps.android.notes.utilits.REPOSITORY
import com.abramkinapps.android.notes.utilits.TYPE_FIREBASE
import com.abramkinapps.android.notes.utilits.TYPE_ROOM
import com.abramkinapps.android.notes.utilits.showToast

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSuccess:()->Unit){

        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
               REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()}, { showToast(it)})
            }
        }

    }
}