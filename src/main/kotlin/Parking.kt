data class Parking(val vehicles: MutableSet<Vehicle>) {
    //first cantVehicle, second profits
    var info : Pair<Int,Int> = Pair(0,0)
    val MAXVEHICLE = 20

    /**
     * This function add a vehicle to the parking.
     * @param vehicle
     */
    fun addVehicle(vehicle: Vehicle) {
        return if (MAXVEHICLE > vehicles.count() && !vehicles.contains(vehicle)) {
            vehicles.add(vehicle)
            println("Welcome to AlkeParking!")
        }
        else {
            println("Sorry, the check-in failed")
        }
    }

    /**
     * This function find the vehicle with the plate, if it exists call the method needed to remove the vehicle
     * or if it doesn't exists, it shows error message
     * @param plate
     */
    fun removeVehicle(plate: String) {
        val vehicle = this.vehicles.find { it.plate == plate }
        vehicle
            ?.let{ ParkingSpace(vehicle, this).checkOutVehicle(vehicle) }
            ?:run{ println("Sorry, the check-out failed. This vehicle not exist in the parking") }
    }

    fun listVehicle(){
        vehicles.forEach{ println(it.plate) }
    }

    fun updateInfo(profits:Int){
        this.info = this.info.copy(first=this.info.first + 1, second=this.info.second+profits)
    }

    fun showInfo(){
        println("${info.first} vehicles have checked out and have earnings of \$${info.second}")
    }
}