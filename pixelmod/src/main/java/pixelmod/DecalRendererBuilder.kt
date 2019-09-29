package pixelmod

enum class DecalRendererAlgorithmType {
    SIFT_DECAL_RENDERER
}

class DecalRendererBuilder {
    fun withRepositoryDescriptor(desc: DecalRepositoryDescriptor): DecalRendererBuilder {
        return this
    }
    fun withRendererAlgorithm(algorithmType: DecalRendererAlgorithmType): DecalRendererBuilder {
        return this
    }
    fun build(): IDecalRenderer {
        throw UnsupportedOperationException()
    }
}