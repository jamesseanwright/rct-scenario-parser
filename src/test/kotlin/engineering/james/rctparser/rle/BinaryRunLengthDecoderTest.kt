package engineering.james.rctparser.rle

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class BinaryRunLengthDecoderTest {
        @Test
        fun decodeRunLengthEncodedBytes() {
                // Example taken from https://freerct.github.io/RCTTechDepot-Archive/RLE.html
                val encoded =
                                arrayOf(
                                                                0x00,
                                                                0x47,
                                                                0xFF,
                                                                0x6F,
                                                                0x05,
                                                                0x64,
                                                                0x20,
                                                                0x6A,
                                                                0x6F,
                                                                0x62,
                                                                0x21
                                                )
                                                .map { x -> x.toByte() }
                                                .toByteArray()

                val expected =
                                arrayOf(0x47, 0x6F, 0x6F, 0x64, 0x20, 0x6A, 0x6F, 0x62, 0x21)
                                                .map { x -> x.toByte() }
                                                .toByteArray()

                val expectedData = "Good job!"

                val actual = decodeBinary(encoded)

                assertFalse(actual.isFailure)
                assertContentEquals(expected, actual.getOrDefault(arrayOf<Byte>().toByteArray()))

                assertEquals(
                                expectedData,
                                actual.getOrDefault(arrayOf<Byte>().toByteArray()).decodeToString()
                )
        }
}
