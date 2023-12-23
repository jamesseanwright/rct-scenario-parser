package engineering.james.rctparser

import engineering.james.rctparser.rle.decodeBinary
import java.io.File

fun getScenarioParser(filename: String): Result<ScenarioParser> =
        when (File(filename).extension) {
            "sc4" -> Result.success(Sc4ScenarioParser(::decodeBinary))
            else -> Result.failure(RuntimeException())
        }
