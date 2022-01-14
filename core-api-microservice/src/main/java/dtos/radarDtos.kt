package dtos

data class RadarRequestDto(
        var vitess: Int,
        var latitude : Double,
        var longitude : Double,
)