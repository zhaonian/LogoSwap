package org.e8yes.pixelmod.renderer

import android.graphics.Bitmap
import org.e8yes.pixelmod.repository.DecalHandle

/**
 * Represents a renderer that draws the specified decal to the corresponding image location, if
 * possible.
 */
interface IDecalRenderer {
    fun render(src: Bitmap, detect: DecalHandle, mod: DecalHandle): Bitmap
}
