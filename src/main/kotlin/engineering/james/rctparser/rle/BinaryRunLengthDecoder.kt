package engineering.james.rctparser.rle

@ExperimentalUnsignedTypes
class BinaryRunLengthDecoder : RunLengthDecoder {
    override fun decode(encoded: ByteArray): Result<ByteArray> {
        val out = mutableListOf<Byte>()
        var i = 0

        // TODO: ignore 4-byte checksum at file end
        while (i < encoded.size) {
            val isEncodedRun = encoded[i] < 0 // i.e. a signed byte with 1 as MSB

            if (isEncodedRun) {
                val n = 1 - encoded[i].toInt()
                out.addAll(ByteArray(n) { encoded[i + 1] }.asList())
                i += 2
            } else {
                val n = i + encoded[i].toInt() + 1
                out.addAll(encoded.slice(i + 1..n))
                i += 1 + n
            }
        }

        return Result.success(out.toByteArray())
    }
}
