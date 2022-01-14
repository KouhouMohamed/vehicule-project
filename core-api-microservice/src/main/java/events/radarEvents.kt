package events

import java.util.*

abstract class BaseEvent<T>(
        open val id : T,
        open val dateEvent : Date
)

data class RadarCreatedEvent(
        override val id : String,
        val vitesse : Int,
        val latitude : Double,
        val longitude : Double,
        override val dateEvent : Date
):BaseEvent<String>(id, dateEvent);

data class RadarUpdatedEvent(
        override val id : String,
        val newVitesse : Int,
        val newLatitude : Double,
        val newLongitude : Double,
        override val dateEvent : Date
):BaseEvent<String>(id, dateEvent);