package engineering.james.rctparser

@ExperimentalUnsignedTypes
class Sc6ScenarioParser : ScenarioParser {
    override fun parse(decompressed: UByteArray): Result<Scenario> =
            Result.failure(UnsupportedOperationException("Not implemented"))
}
