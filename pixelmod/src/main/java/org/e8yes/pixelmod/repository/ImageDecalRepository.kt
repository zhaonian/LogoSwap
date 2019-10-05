package org.e8yes.pixelmod.repository

import android.graphics.Bitmap

data class ImageDecal(val handle: DecalHandle, val path: String, val image: Bitmap)

/** A collection of decals in the form of physical files. */
class ImageDecalRepository : IDecalRepository {

    private val descriptor: DecalRepositoryDescriptor
    private val decals: List<ImageDecal> = ArrayList()

    constructor(descriptor: DecalRepositoryDescriptor) {
        this.descriptor = descriptor

        // TODO: Read and parse index file then load in all images in the repository.
    }

    override fun decals(): List<DecalHandle> {
        return decals.map { decal -> decal.handle }.toList()
    }

    override fun descriptor(): DecalRepositoryDescriptor {
        return descriptor
    }

    fun imageDecal(handle: DecalHandle): ImageDecal? {
        return decals.findLast { decal -> decal.handle == handle }
    }
}
