data class Parking(val vehicles: MutableSet<Vehicle>) {
    //first cantVehicle, second profits
    var info : Pair<Int,Int> = Pair(0,0)
    val maxVehicle = 20

    fun addVehicle(vehicle: Vehicle) : Boolean{
        return if (maxVehicle > vehicles.count() && !vehicles.contains(vehicle)) {
            vehicles.add(vehicle)
            println("Welcome to AlkeParking!")
            true
        }
        else {
            println("Sorry, the check-in failed")
            false
        }
    }

    fun removeVehicle(plate:String){
        val vehicle = this.vehicles.find { it.plate == plate}
        vehicle
            ?.let{ParkingSpace(it).checkOutVehicle(vehicle.plate)}
            ?:run{ println("This vehicle not exist in the parking")}
    }

    fun listVehicle(){
        vehicles.forEach{println(it.plate)}
    }

    fun updateInfo(profits:Int){
        this.info= this.info.copy(first=this.info.first + 1, second=this.info.second+profits)
    }

    fun showInfo(){
        println("${info.first} vehicles have checked out and have earnings of \$${info.second}")
    }
}