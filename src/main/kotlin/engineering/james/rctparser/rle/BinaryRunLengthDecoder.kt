package engineering.james.rctparser.rle

@ExperimentalUnsignedTypes
class BinaryRunLengthDecoder : RunLengthDecoder {
    override fun decode(encoded: UByteArray): Result<UByteArray> =
            Result.failure(UnsupportedOperationException("Not implemented"))
}
