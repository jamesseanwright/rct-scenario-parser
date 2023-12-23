package engineering.james.rctparser

interface ScenarioParser {
    fun parse(data: ByteArray): Result<Scenario>
}
