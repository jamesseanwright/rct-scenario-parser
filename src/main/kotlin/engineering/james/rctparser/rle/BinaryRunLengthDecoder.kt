package engineering.james.rctparser.rle

val checksumLength = 4

// I had attempted to write this more functionally, but
// it proved to be orders of magnitude slower, to the
// extent at which it'd take over a minute to parse a
// 300KB file!
fun decodeBinary(encoded: ByteArray): ByteArray {
    val out = mutableListOf<Byte>()
    var i = 0

    while (i < encoded.size - checksumLength) {
        val isEncodedRun = encoded[i] < 0 // i.e. a signed byte with 1 as MSB

        if (isEncodedRun) {
            val n = 1 - encoded[i].toInt()
            out.addAll(ByteArray(n) { encoded[i + 1] }.asList())
            i += 2
        } else {
            val n = i + encoded[i].toInt() + 1
            out.addAll(encoded.slice(i + 1..n))
            i = 1 + n
        }
    }

    return out.toByteArray()
}
