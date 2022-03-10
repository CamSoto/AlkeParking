import AlkeParking.Companion.parking
import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle) {
    val MINUTES_IN_MILISECONDS = 60000
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    fun checkOutVehicle(vehiclePlate: String){
        val vehicle = parking.vehicles.find { it.plate == vehiclePlate }
        vehicle?.let {
            //If there is no discountCard or if it is empty, the discount is not applied.
            val amount: Int = calculateFee(vehicle.type, parkedTime, !vehicle.discountCard.isNullOrEmpty())
            onSuccess(amount)
            parking.vehicles.remove(vehicle)
        } ?: run {
            onError()
        }
    }

    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscount: Boolean) : Int {
        val fee = if (parkedTime <= 120) {
            type.fee
        } else {
            //.toInt() Converts this Float value to Int. The fractional part, if any, is rounded down towards zero.
            (ceil(((parkedTime.toDouble() - 120) / 15)) * 5 + type.fee).toInt()
        }
        return if(hasDiscount) fee * 85 /100 else fee
    }

    fun onSuccess(amount: Int){
        parking.updateInfo(amount)
        println("Your fee is \$$amount Come back soon.")
    }

    fun onError(){
        println("Sorry, the check-out failed")
    }
}