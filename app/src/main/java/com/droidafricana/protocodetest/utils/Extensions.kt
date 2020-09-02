package com.droidafricana.protocodetest.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun View.makeSnack(message: String) {
    Snackbar.make(
        this,
        message,
        Snackbar.LENGTH_LONG
    )
        .show()
}

fun Fragment.makeToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
