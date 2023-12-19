package engineering.james.rctparser.rle

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

@ExperimentalUnsignedTypes
class BinaryRunLengthDecoderTest {
    @Test
    fun decodeRunLengthEncodedBytes() {
        // Example taken from https://freerct.github.io/RCTTechDepot-Archive/RLE.html
        val encoded =
                arrayOf(0x00, 0x47, 0xFF, 0x6F, 0x05, 0x64, 0x20, 0x6A, 0x6F, 0x62, 0x21)
                        .map { x -> x.toUByte() }
                        .toUByteArray()

        val expected =
                arrayOf(0x47, 0x6F, 0x6F, 0x64, 0x20, 0x6A, 0x6F, 0x62, 0x21)
                        .map { x -> x.toUByte() }
                        .toUByteArray()

        val expectedData = "Good job!"

        val decoder = BinaryRunLengthDecoder()
        val actual = decoder.decode(encoded)

        assertFalse(actual.isFailure)
        assertEquals(expected, actual.getOrDefault(arrayOf<UByte>().toUByteArray()))

        assertEquals(
                expectedData,

                // TODO: worth asserting that returned data
                // can safely be converted from unsigned to
                // signed bytes
                actual.getOrDefault(arrayOf<UByte>().toUByteArray()).toByteArray().decodeToString()
        )
    }
}
