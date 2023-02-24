package com.dragdrop.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.*


infix fun Context.showToast(msg:String) = Toast.makeText(this,msg,Toast.LENGTH_LONG).show()

fun Context.playName(speech:String="wrong", isPlay:Boolean=true){
    if (isPlay){
        var textToSpeech: TextToSpeech?=null
        textToSpeech = TextToSpeech(
            this
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech?.apply {
                    language = Locale.forLanguageTag("hi")
                    speak(speech, TextToSpeech.QUEUE_FLUSH, null,"");
                }
            }
        }
    }
}