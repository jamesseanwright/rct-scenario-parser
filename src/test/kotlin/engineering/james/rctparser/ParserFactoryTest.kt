package engineering.james.rctparser

import java.io.File
import kotlin.getOrThrow
import kotlin.test.Test
import kotlin.test.assertTrue

class ParserFactoryTest {
    @Test
    fun getScenarioParserWithSc4FileReturnsSc4ScenarioParser() {
        val res = getScenarioParser(File("/foo/bar.sc4"))

        assertTrue(res.isSuccess)
        assertTrue(
            res.getOrThrow() is Sc4ScenarioParser,
            "Parser is not an instance of Sc4ScenarioParser"
        )
    }

    @Test
    fun getScenarioParserWithSc6FileRejectsWithUnsupportedScenarioFormatException() {
        val res = getScenarioParser(File("/foo/bar.sc6"))

        assertTrue(res.isFailure)
        assertTrue(
            res.exceptionOrNull() is UnsupportedScenarioFormatException,
            "Throwable is not instance of UnsupportedScenarioFormatException"
        )
    }

    @Test
    fun getScenarioParserWithUnrecognisedFormatRejectsWithInvalidScenarioFormatException() {
        val res = getScenarioParser(File("/foo/bar.foo"))

        assertTrue(res.isFailure)
        assertTrue(
            res.exceptionOrNull() is InvalidScenarioFormatException,
            "Throwable is not instance of InvalidScenarioFormatException"
        )
    }
}
