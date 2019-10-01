package io.pixelmod.renderer

import android.graphics.Bitmap
import io.pixelmod.repository.DecalHandle

/**
 * Represents a renderer that draws the specified decal to the corresponding image location, if
 * possible.
 */
interface IDecalRenderer {
    fun render(src: Bitmap, decal: DecalHandle): Bitmap
}
