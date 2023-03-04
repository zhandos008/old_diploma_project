package com.bignerdranch.android.diplomaproject

import android.app.Application

class DocumentIntentApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DocumentRepository.initialize(this)
    }
}