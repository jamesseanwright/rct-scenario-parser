package engineering.james.rctparser

import kotlin.getOrThrow
import kotlin.test.Test
import kotlin.test.assertTrue

class ParserFactoryTest {
    @Test
    fun getScenarioParserWithSc4FileReturnsSc4ScenarioParser() {
        val res = getScenarioParser("/foo/bar.sc4")

        assertTrue(res.isSuccess)
        assertTrue(
                res.getOrThrow() is Sc4ScenarioParser,
                "Parser is not an instance of Sc4ScenarioParser"
        )
    }
}
