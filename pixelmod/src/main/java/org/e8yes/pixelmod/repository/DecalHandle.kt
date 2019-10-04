package org.e8yes.pixelmod.repository

import android.graphics.Bitmap

/** A pointer to one of the items in the IDecalRepository. */
data class DecalHandle(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: Bitmap
)
