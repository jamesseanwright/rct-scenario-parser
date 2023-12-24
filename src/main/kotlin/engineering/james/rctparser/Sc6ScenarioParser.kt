package engineering.james.rctparser

class Sc6ScenarioParser : ScenarioParser {
    override fun parse(data: ByteArray): Result<Scenario> =
        Result.failure(UnsupportedOperationException("Not implemented"))
}
