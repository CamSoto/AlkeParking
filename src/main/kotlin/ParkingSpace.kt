import AlkeParking.Companion.parking
import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle, var parking: Parking) {
    val MINUTES_IN_MILISECONDS = 60000
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS
<<<<<<< HEAD
    fun checkOutVehicle(vehiclePlate: String){
        val v = parking.vehicles.find { it.plate == vehiclePlate }
        v?.let {
            val amount: Int = calculateFee(v.type, parkedTime, v.discountCard)
            onSuccess(amount)
            parking.vehicles.remove(v)
=======

    fun checkOutVehicle(vehiclePlate: String){
        val vehicle = parking.vehicles.find { it.plate == vehiclePlate }
        vehicle?.let {
            //If there is no discountCard or if it is empty, the discount is not applied.
            val amount: Int = calculateFee(vehicle.type, parkedTime, !vehicle.discountCard.isNullOrEmpty())
            onSuccess(amount)
            parking.vehicles.remove(vehicle)
>>>>>>> develop
        } ?: run {
            onError()
        }
    }

<<<<<<< HEAD
    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscount: String?) : Int {
        val fee = if (parkedTime <= 120) {
            type.fee
        } else {
            (ceil(((parkedTime.toDouble() - 120) / 15)) * 5 + type.fee).toInt()
        }
        return hasDiscount?.let { fee * 85 / 100 } ?: run { fee }
    }

    fun checkInVehicle(vehicle: Vehicle){
        if (parking.addVehicle(vehicle)) println("Welcome to AlkeParking!")
        else println("Sorry, the check-in failed")
    }

    fun onSuccess(amount: Int){
        //TODO
    }

    fun onError(){
        //TODO
    }

=======
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
>>>>>>> develop
}