package com.lroap.platziconf.view.adapter


import com.lroap.platziconf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}