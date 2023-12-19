package engineering.james.rctparser

@ExperimentalUnsignedTypes
interface ScenarioParser {
    fun parse(decompressed: UByteArray): Result<Scenario>
}
