package engineering.james.rctparser.rle

interface RunLengthDecoder {
    fun decode(encoded: ByteArray): Result<ByteArray>
}
