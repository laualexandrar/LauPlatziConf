package com.lroap.platziconf.model

import java.io.Serializable
import java.util.*

class Conference : Serializable{
    lateinit var speaker: String
    lateinit var title:String
    lateinit var description:String
    lateinit var tag: String
    lateinit var datetime: Date

}