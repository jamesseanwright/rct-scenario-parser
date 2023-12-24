package engineering.james.rctparser

import engineering.james.rctparser.rle.decodeBinary
import java.io.File

fun getScenarioParser(file: File): Result<ScenarioParser> =
    when (val ext = file.extension) {
        "sc4" -> Result.success(Sc4ScenarioParser(::decodeBinary))
        "sc6" -> Result.failure(UnsupportedScenarioFormatException(ext))
        else -> Result.failure(InvalidScenarioFormatException(ext))
    }
