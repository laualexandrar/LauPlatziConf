package com.lroap.platziconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.lroap.platziconf.model.Conference
import com.lroap.platziconf.model.Speaker


const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"


class FirestoreService{
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build() // para datos offline

    init {
        firebaseFirestore.firestoreSettings = settings // datos offline
    }
    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for(doc in result){
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for(doc in result){
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }

    }
}