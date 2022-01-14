package events

import lombok.Getter
import java.util.*

abstract class BaseEvent<T>(
        @Getter open val id : T,
        @Getter open val dateEvent : Date
)

data class RadarCreatedEvent(
        override val id : String,
        @Getter val vitesse : Int,
        @Getter val latitude : Double,
        @Getter val longitude : Double,
        override val dateEvent : Date
):BaseEvent<String>(id, dateEvent);

data class RadarUpdatedEvent(
        override val id : String,
        @Getter val newVitesse : Int,
        @Getter val newLatitude : Double,
        @Getter val newLongitude : Double,
        override val dateEvent : Date
):BaseEvent<String>(id, dateEvent);