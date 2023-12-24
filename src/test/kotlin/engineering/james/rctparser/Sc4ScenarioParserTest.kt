package engineering.james.rctparser

import engineering.james.rctparser.rle.decodeBinary
import java.math.BigDecimal
import kotlin.getOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sc4ScenarioParserTest {
    private var v1ScenarioData = byteArrayOf()
    private var v11ScenarioData = byteArrayOf()

    init {
        this.v1ScenarioData = this::class.java.getResourceAsStream("/sc101.sc4").readAllBytes()
        this.v11ScenarioData = this::class.java.getResourceAsStream("/pcgw.sc4").readAllBytes()
    }

    @Test
    fun parseSc4FormatScenario() {
        val parser = Sc4ScenarioParser(::decodeBinary)
        val res = parser.parse(this.v1ScenarioData)

        assertTrue(res.isSuccess)
        assertEquals("Micro Dynamite Dunes", res.getOrThrow().name)
        assertEquals(BigDecimal(25000), res.getOrThrow().availableCash)
    }

    // TODO: ultimately support scenarios created for expansion
    // packs (see https://freerct.github.io/RCTTechDepot-Archive/SC4.html)
    @Test
    fun parseExpansionPackScenarioRejects() {
        val parser = Sc4ScenarioParser(::decodeBinary)
        val res = parser.parse(this.v11ScenarioData)

        assertTrue(res.isFailure)
        assertTrue(
            res.exceptionOrNull() is UnsupportedGameVersionException,
            "Throwable is not instance of UnsupportedGameVersionException"
        )
    }
}
