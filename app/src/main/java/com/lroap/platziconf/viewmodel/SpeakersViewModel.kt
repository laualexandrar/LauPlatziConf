package com.lroap.platziconf.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lroap.platziconf.model.Speaker
import com.lroap.platziconf.network.Callback
import com.lroap.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakersViewModel: ViewModel(){
    val firestoreService = FirestoreService()
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase(){
        firestoreService.getSpeakers(object: Callback<List<Speaker>>{
            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }

}