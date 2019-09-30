package io.pixelmod.repository

/**
 * A collection of decals in the form of physical files.
 */
class ImageDecalRepository(private val descriptor: DecalRepositoryDescriptor) : IDecalRepository {

    override fun decals(): List<DecalHandle> {
        TODO("not implemented")
    }

    override fun descriptor(): DecalRepositoryDescriptor {
        return descriptor
    }
}
