import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    val MINUTES_IN_MILISECONDS = 60000
    private val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    /**
     * This function is in charge of collecting the data to then call calculateFee and if everything is satisfactory, remove the vehicle
     * @param vehicle to retrieve information and then remove
     */
    fun checkOutVehicle(vehicle: Vehicle) {
          try {
              //If there is no discountCard or if it is empty, the discount is not applied.
              val amount: Int = calculateFee(vehicle.type, parkedTime, !vehicle.discountCard.isNullOrEmpty())
              onSuccess(amount)
              parking.vehicles.remove(vehicle)
          } catch (e: Exception) {
              onError()
          }
    }

    /**
     * This function performs the calculation taking into account the type of vehicle, the time and the discount if it has one.
     * @param type (enum class)
     * @param parkedTime (vehicle parking time)
     * @param hasDiscount (discount card)
     * @return fee:Int calculation value
     */
    private fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscount: Boolean) : Int {
        val fee = if (parkedTime <= 120) {
            type.fee
        } else {
            //.toInt() Converts this Float value to Int. The fractional part, if any, is rounded down towards zero.
            //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/to-int.html
            (ceil(((parkedTime.toDouble() - 120) / 15)) * 5 + type.fee).toInt()
        }
        return if(hasDiscount) fee * 85 /100 else fee
    }

    private fun onSuccess(amount: Int){
        parking.updateInfo(amount)
        println("Your fee is \$$amount Come back soon.")
    }

    private fun onError(){
        println("Sorry, the check-out failed")
    }
}