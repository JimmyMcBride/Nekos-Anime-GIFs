package com.example.nekosanimegifs.extentions

import android.view.LayoutInflater
import android.view.ViewGroup

val ViewGroup.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(context)