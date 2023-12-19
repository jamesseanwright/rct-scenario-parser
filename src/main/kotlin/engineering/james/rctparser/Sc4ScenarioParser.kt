package engineering.james.rctparser

@ExperimentalUnsignedTypes
class Sc4ScenarioParser : ScenarioParser {
    override fun parse(decompressed: UByteArray): Result<Scenario> =
            Result.failure(UnsupportedOperationException("Not implemented"))
}
