package io.pixelmod

import org.opencv.android.OpenCVLoader

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

    companion object {
        /**
         * TODO: remove this, this is just a dummy function to test if openCV has been set up
         * properly
         */
        fun initOpenCvTest(): Boolean {
            return OpenCVLoader.initDebug()
        }
    }
}
