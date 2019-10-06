package org.e8yes.pixelmod.renderer

import android.graphics.Bitmap
import org.e8yes.pixelmod.repository.DecalHandle

/**
 * Represents a renderer that draws the specified decal to the corresponding image location, if
 * possible.
 */
interface IDecalRenderer {

    /**
     * Takes in an input image src then detects a sub-region that matches the decal srcDecal, if
     * possible, and returns the resulting image where dstDecal is rendered onto the matched
     * sub-region. If the detection fails, it will return the input image.
     */
    fun render(src: Bitmap, srcDecal: DecalHandle, dstDecal: DecalHandle): Bitmap
}
