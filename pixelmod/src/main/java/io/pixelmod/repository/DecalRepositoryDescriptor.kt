package io.pixelmod.repository

enum class DecalRepositoryType {
    ImageDecalRepository,
    ModelBasedRepository
}

/**
 * A description detailed enough to load any IDecalRepository.
 */
data class DecalRepositoryDescriptor(val type: DecalRepositoryType,
                                     val fileLocation: String)
