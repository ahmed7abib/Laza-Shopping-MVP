package com.example.common

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.showSnackBar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}

fun Context.setTypeFace(view: List<TextView>, font: String) {
    view.forEach {
        it.typeface = Typeface.createFromAsset(this.assets, font)
    }
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun String.isValidEmail(): Boolean {
    return this.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun getRandom(from: Int, to: Int) = (Math.random() * (to - from + 1) + from).toInt()