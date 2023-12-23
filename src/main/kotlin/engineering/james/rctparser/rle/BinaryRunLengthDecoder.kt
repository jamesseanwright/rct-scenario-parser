package engineering.james.rctparser.rle

fun decodeBinary(encoded: ByteArray): ByteArray {
    fun iterate(acc: List<Byte> = listOf<Byte>(), i: Int = 0): List<Byte> {
        when {
            i == encoded.size -> return acc
            isEncodedRun(encoded[i]) -> {
                val n = 1 - encoded[i].toInt()
                return iterate(acc + List(n) { encoded[i + 1] }, i + 2)
            }
            else -> {
                val n = i + encoded[i].toInt() + 1
                return iterate(acc + encoded.slice(i + 1..n), n + 1)
            }
        }
    }

    return iterate().toByteArray()
}

fun isEncodedRun(byte: Byte) = byte < 0 // i.e. MSB is 1
