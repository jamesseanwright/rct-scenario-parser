package engineering.james.rctparser

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Sc4ScenarioParserTest {
    private var scenarioData = byteArrayOf()

    init {
        val stream = this::class.java.getResourceAsStream("/pcgw.sc4")
        this.scenarioData = stream.readAllBytes()
    }

    @Test
    fun parseSc4FormatScenario() {
        val parser = Sc4ScenarioParser()
        val res = parser.parse(this.scenarioData)

        assertTrue(res.isSuccess)
        assertEquals("PC Gaming World", res.getOrDefault(emptyScenario()).name)
    }
}
