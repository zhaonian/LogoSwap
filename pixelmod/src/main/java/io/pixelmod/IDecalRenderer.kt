package io.pixelmod

import android.graphics.Bitmap

interface IDecalRenderer {
    fun render(src: Bitmap): Bitmap
}