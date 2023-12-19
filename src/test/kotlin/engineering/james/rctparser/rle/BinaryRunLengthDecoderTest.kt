package engineering.james.rctparser.rle

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BinaryRunLengthDecoderTest {
    @Test
    fun decodeRunLengthEncodedBytes() {
        // Example taken from https://freerct.github.io/RCTTechDepot-Archive/RLE.html
        val encoded = byteArrayOf(0x00, 0x47, -0x1, 0x6F, 0x05, 0x64, 0x20, 0x6A, 0x6F, 0x62, 0x21)
        val expected = byteArrayOf(0x47, 0x6F, 0x6F, 0x64, 0x20, 0x6A, 0x6F, 0x62, 0x21)
        val expectedData = "Good job!"
        val actual = decodeBinary(encoded)

        assertFalse(actual.isFailure)
        assertContentEquals(expected, actual.getOrDefault(byteArrayOf()))
        assertEquals(expectedData, actual.getOrDefault(byteArrayOf()).decodeToString())
    }
}
