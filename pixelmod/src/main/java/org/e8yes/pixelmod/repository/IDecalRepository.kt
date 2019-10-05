package org.e8yes.pixelmod.repository

/**
 * An abstract representation of a collection of decal images. Note that: a decal does not have to
 * be in the form of physical image file. It doesn't even have to be in any way decodable.
 */
interface IDecalRepository {

    /** Returns all possible decal selections from the repository. */
    fun decals(): List<DecalHandle>

    /** The descriptor was used to construct this repository. */
    fun descriptor(): DecalRepositoryDescriptor
}
