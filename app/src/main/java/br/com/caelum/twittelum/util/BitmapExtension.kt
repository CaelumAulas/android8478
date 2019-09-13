package br.com.caelum.twittelum.util

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun Bitmap.toBase64(): String {

    val outputStream = ByteArrayOutputStream()

    compress(Bitmap.CompressFormat.JPEG, 100, outputStream)

    val arrayDeBytes = outputStream.toByteArray()

    return Base64.encodeToString(arrayDeBytes, Base64.DEFAULT)
}