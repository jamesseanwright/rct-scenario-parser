package engineering.james.rctparser.rle

fun decodeBinary(encoded: ByteArray): Result<ByteArray> {
    fun iterate(acc: List<Byte> = listOf<Byte>(), i: Int = 0): List<Byte> {
        if (i == encoded.size) {
            return acc
        }

        val isEncodedRun = encoded[i] < 0 // i.e. a signed byte with 1 as MSB

        if (isEncodedRun) {
            val n = 1 - encoded[i].toInt()
            return iterate(acc + ByteArray(n) { encoded[i + 1] }.asList(), i + 2)
        }

        val n = i + encoded[i].toInt() + 1
        return iterate(acc + encoded.slice(i + 1..n), n + 1)
    }

    return Result.success(iterate().toByteArray())
}
