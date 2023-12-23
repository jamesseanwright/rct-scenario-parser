package engineering.james.rctparser

import engineering.james.rctparser.rle.decodeBinary
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sc4ScenarioParserTest {
    private var scenarioData = byteArrayOf()

    init {
        val stream = this::class.java.getResourceAsStream("/sc101.sc4")
        this.scenarioData = stream.readAllBytes()
    }

    @Test
    fun parseSc4FormatScenario() {
        val parser = Sc4ScenarioParser(::decodeBinary)
        val res = parser.parse(this.scenarioData)

        assertTrue(res.isSuccess)
        assertEquals("Micro Dynamite Dunes", res.getOrDefault(emptyScenario()).name)
    }
}
