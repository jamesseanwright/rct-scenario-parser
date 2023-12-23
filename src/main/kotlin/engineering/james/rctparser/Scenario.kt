package engineering.james.rctparser

import java.math.BigDecimal

enum class ParkStatus {
    CLOSED,
    OPEN,
}

enum class GuestIntensityPreference {
    LOW,
    HIGH,
}

data class Scenario(
        val name: String,
        val availableCash: BigDecimal,
        val loanAmount: BigDecimal,
        val guestCount: Int,
        val vehicleCount: Int,
        val parkStatus: ParkStatus,
        val guestIntensityPreference: GuestIntensityPreference,
)

val emptyScenario =
        Scenario(
                "",
                BigDecimal(0),
                BigDecimal(0),
                0,
                0,
                ParkStatus.CLOSED,
                GuestIntensityPreference.LOW,
        )
