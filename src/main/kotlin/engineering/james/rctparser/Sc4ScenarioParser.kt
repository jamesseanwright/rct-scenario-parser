package engineering.james.rctparser

import java.math.BigDecimal

typealias RunLengthDecoder = (ByteArray) -> ByteArray

val nameLocation = 0x1F8314..0x1F8351

class Sc4ScenarioParser(val decode: RunLengthDecoder) : ScenarioParser {
        override fun parse(data: ByteArray): Result<Scenario> {
                val decoded = decode(data)
                val name =
                                decoded.slice(nameLocation)
                                                .toByteArray()
                                                .decodeToString()
                                                .replace("\u0000", "")

                return Result.success(
                                Scenario(
                                                name,
                                                BigDecimal(0),
                                                BigDecimal(0),
                                                0,
                                                0,
                                                ParkStatus.CLOSED,
                                                GuestIntensityPreference.LOW,
                                )
                )
        }
}
