package engineering.james.rctparser

class UnsupportedGameVersionException :
        RuntimeException("Game version for which the scenario was made is currently unsupported")

class UnsupportedScenarioFormatException(val format: String) :
        RuntimeException("$format scenarios are currently not supported")

class InvalidScenarioFormatException(val format: String) :
        RuntimeException("$format is not a valid scenario format")
