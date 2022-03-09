import kotlin.concurrent.timer

fun main(args: Array<String>) {

    val arrayVehicles: Array<Vehicle> = arrayOf(
        Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001"),
        Vehicle("B222BBB", VehicleType.MOTORCYCLE),
        Vehicle("CC333CC", VehicleType.MINIBUS),
        Vehicle("DD444DD", VehicleType.BUS, discountCard = "DISCOUNT_CARD_002"),
        Vehicle("AA111FA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_003"),
        Vehicle("AA111HA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_004"),
        Vehicle("B222BNB", VehicleType.MOTORCYCLE),
        Vehicle("CC633CC", VehicleType.MINIBUS),
        Vehicle("DD844DD", VehicleType.BUS),
        Vehicle("AA911AA", VehicleType.CAR),
        Vehicle("AA191AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_005"),
        Vehicle("B221BBB", VehicleType.MOTORCYCLE),
        Vehicle("C1333CC", VehicleType.MINIBUS),
        Vehicle("DL444DD", VehicleType.BUS, discountCard = "DISCOUNT_CARD_006"),
        Vehicle("AS111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_007"),
        Vehicle("AA111AA", VehicleType.CAR),
        Vehicle("AMJJ1AA", VehicleType.CAR),
        Vehicle("BN26BBB", VehicleType.MOTORCYCLE),
        Vehicle("CC303CC", VehicleType.MINIBUS),
        Vehicle("DD484DD", VehicleType.BUS, discountCard = "DISCOUNT_CARD_008"),
        Vehicle("AA101AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_009"),
        Vehicle("AM111AA", VehicleType.CAR)
    )

    val parking = Parking(mutableSetOf())
    lateinit var parkingSpace: ParkingSpace
    for (i in arrayVehicles){
        parkingSpace = ParkingSpace(i, parking)
        parkingSpace.checkInVehicle(i)
    }

    parkingSpace.checkOutVehicle("AA111AA")



//    fun checkIn(array: Array<Vehicle>){
//        for (i in array){
//            if (parking.addVehicle(i)) println("Welcome to AlkeParking!")
//            else println("Sorry, the check-in failed")
//        }
//    }

    //for (i in arrayVehicles){
    //    if (parking.addVehicle(i)) println("Welcome to AlkeParking!")
    //    else println("Sorry, the check-in failed")
    //}

//    checkIn(arrayVehicles)
    //val parking = Parking(mutableSetOf(car, motorcycle, minibus, bus))
    //println(parking.vehicles.contains(car))
    //println(parking.vehicles.contains(motorcycle))
    //println(parking.vehicles.contains(minibus))
    //println(parking.vehicles.contains(bus))
    //parking.vehicles.remove(motorcycle)
    //println(parking.vehicles.size)
}

