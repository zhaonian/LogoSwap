package org.e8yes.pixelmod.renderer

import org.e8yes.pixelmod.repository.IDecalRepository

/** Build a decal renderer that satisfies the specified options. */
abstract class DecalRendererBuilder {

    abstract val repository: IDecalRepository
    abstract val algorithmType: DecalRendererAlgorithmType

    fun withRepository(desc: IDecalRepository): DecalRendererBuilder {
        return this
    }

    fun withRendererAlgorithm(algorithmType: DecalRendererAlgorithmType): DecalRendererBuilder {
        return this
    }

    fun build(): IDecalRenderer {
        TODO("not implemented")
    }
}
