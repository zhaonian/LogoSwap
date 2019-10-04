package org.e8yes.pixelmod.renderer

import android.graphics.Bitmap
import org.e8yes.pixelmod.repository.DecalHandle
import org.e8yes.pixelmod.repository.ImageDecalRepository

/**
 * Tries to match object in the src image with that selected from the repository using SIFT matcher.
 * If the matching is successful, a homography transform can be computed, and the matched decal will
 * be transformed according to the homography. Necessary screen-space filtering will be performed
 * afterwards to smooth out edges.
 */
class SiftDecalRenderer(val repository: ImageDecalRepository) : IDecalRenderer {

    override fun render(src: Bitmap, decal: DecalHandle): Bitmap {
        TODO("not implemented")
    }
}
