package exceptions

data class NegativeVitesseException(
        override var message : String
):RuntimeException(message)