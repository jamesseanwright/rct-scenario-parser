package engineering.james.rctparser

import java.math.BigDecimal

typealias RunLengthDecoder = (ByteArray) -> ByteArray

val parkNameOffset = 0x19882C..0x19882F

class Sc4ScenarioParser(val decode: RunLengthDecoder) : ScenarioParser {
        override fun parse(data: ByteArray): Result<Scenario> {
                val decoded = decode(data)
                val parkName =
                                decoded.copyOfRange(parkNameOffset.first, parkNameOffset.last)
                                                .decodeToString()

                return Result.success(
                                Scenario(
                                                parkName,
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
