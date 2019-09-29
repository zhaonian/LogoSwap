package pixelmod

import android.graphics.Bitmap

interface IDecalRenderer {
    fun render(src: Bitmap): Bitmap
}