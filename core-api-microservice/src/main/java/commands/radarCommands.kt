package commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id : T,
        open val date : Date
)

data class RadarCreateCommand(
        override val id : String,
        val vitesse_max : Int,
        val latitude : Double,
        val longitude : Double,
        override val date : Date

):BaseCommand<String>(id, date);

data class RadarUpdateCommand(
        override val id : String,
        val newVitesse_max : Int,
        val newLatitude : Double,
        val newLongitude : Double,
        override val date : Date
):BaseCommand<String>(id,date);

