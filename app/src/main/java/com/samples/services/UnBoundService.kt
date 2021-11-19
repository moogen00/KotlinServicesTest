package com.samples.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

import com.samples.R
import android.media.MediaPlayer.OnCompletionListener
import android.util.Log


/**
 * Created by Anukool Srivastav on 12/01/18.
 */

class UnBoundService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show()

        mediaPlayer = MediaPlayer.create(this, R.raw.intro)

        mediaPlayer.setOnCompletionListener(MediaPlayer.OnCompletionListener {
            // override fun
            //it // this is MediaPlayer type
            Log.d("UnBoundService","setOnCompletionListener OnCompletionListener called")
            // do other task
            stopSelf()
        })
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show()
        mediaPlayer.start()
//        val cnt = 100
//        while (true) {
//            Log.d("Service", "onStartCommand -----------------")
//            Thread.sleep(1000L)
//        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()


        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show()
        mediaPlayer.stop()


    }
}
