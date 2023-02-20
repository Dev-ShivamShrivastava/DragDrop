package com.dragdrop.views.fragment.contactus

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.dragdrop.R
import com.dragdrop.utils.showToast

class ContactUsVM : ViewModel() {

    val message by lazy { ObservableField("") }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.findNavController().navigateUp()
            R.id.btnSubmit -> {
                when {
                    message.get()?.trim()?.isEmpty() == true -> {
                        view.context.showToast("Please enter feedback or query")
                    }
                    (message.get()?.trim()?.length ?: 0) < 3 -> {
                        view.context.showToast("Please enter valid feedback or query")
                    }
                    else -> {
                        sendMail(view.context)
                    }
                }
            }
        }
    }

    private fun sendMail(context: Context) {
        context.startActivity(Intent.createChooser(Intent(Intent.ACTION_SEND_MULTIPLE).apply {
            val recipients = arrayOf("shivamshrivastavaad@gmail.com")
            putExtra(Intent.EXTRA_EMAIL, recipients)
            putExtra(Intent.EXTRA_SUBJECT, "Feedback for app")
            putExtra(Intent.EXTRA_TEXT, message.get())
            type = "text/html"
            `package` = "com.google.android.gm"
        }, "Send mail"))

    }
}