import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle, var parking: Parking) {
    val MINUTES_IN_MILISECONDS = 60000
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS
    fun checkOutVehicle(vehiclePlate: String){
        val v = parking.vehicles.find { it.plate == vehiclePlate }
        v?.let {
            val amount: Int = calculateFee(v.type, parkedTime, v.discountCard)
            onSuccess(amount)
            parking.vehicles.remove(v)
        } ?: run {
            onError()
        }
    }

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

}