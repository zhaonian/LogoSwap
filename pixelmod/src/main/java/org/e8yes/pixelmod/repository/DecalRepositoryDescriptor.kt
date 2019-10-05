package org.e8yes.pixelmod.repository

enum class DecalRepositoryType {
    ImageDecalRepository,
    ModelBasedRepository
}

/** A description detailed enough to load any IDecalRepository. */
data class DecalRepositoryDescriptor(
    val type: DecalRepositoryType,
    val fileLocation: String
)
