package engineering.james.rctparser.rle

@ExperimentalUnsignedTypes
interface RunLengthDecoder {
    fun decode(encoded: ByteArray): Result<ByteArray>
}
