/*por que usamos un set? porque si.
* y porque no tiene repetidos , los objetos?? son unicos*/
data class Parking(val vehicles: MutableSet<Vehicle>) {

    val maxVehicle = 20

    fun addVehicle(vehicle: Vehicle) : Boolean{
        return if (maxVehicle > vehicles.count() && !vehicles.contains(vehicle)) {
            vehicles.add(vehicle)
            true
        }
        else {
            false
        }

    }
}