package engineering.james.rctparser

import java.math.BigDecimal
import java.math.BigInteger

typealias RunLengthDecoder = (ByteArray) -> ByteArray

val nameLocation = 0x1F8314..0x1F8351
val cashLocation = 0x198834..0x198837
val gameVersionLocation = 0x199C14..0x199C17
val maxSupportedGameVersion = 109999.toBigInteger()

class Sc4ScenarioParser(val decode: RunLengthDecoder) : ScenarioParser {
    override fun parse(data: ByteArray): Result<Scenario> {
        val decoded = decode(data)

        val gameVersion = BigInteger(decoded.slice(gameVersionLocation).reversed().toByteArray())

        if (gameVersion > maxSupportedGameVersion) {
            return Result.failure(UnsupportedGameVersionException())
        }

        val name = decoded.slice(nameLocation).toByteArray().decodeToString().replace("\u0000", "")

        val cash =
            BigInteger(decoded.slice(cashLocation).reversed().toByteArray()) / 10.toBigInteger()

        return Result.success(
            Scenario(
                name,
                cash.toBigDecimal(),
                BigDecimal(0),
                0,
                0,
                ParkStatus.CLOSED,
                GuestIntensityPreference.LOW,
            )
        )
    }
}
