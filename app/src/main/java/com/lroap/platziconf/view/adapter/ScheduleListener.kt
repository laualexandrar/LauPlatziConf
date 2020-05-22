package com.lroap.platziconf.view.adapter

import com.lroap.platziconf.model.Conference


interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}