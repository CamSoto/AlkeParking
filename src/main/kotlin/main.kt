/*
QA - Why is vehicles defined as a Set ?
Because a Set is a generic unordered collection of elements that does not support duplicate elements.
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/
 */

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

    for (i in arrayVehicles){
        parking.addVehicle(i)
    }

    parking.listVehicle()
    parking.removeVehicle("AA911AA")
    parking.showInfo()
    parking.addVehicle(Vehicle("B222BNB", VehicleType.MOTORCYCLE))
    parking.addVehicle(Vehicle("B222BKB", VehicleType.MINIBUS))
    parking.removeVehicle("CC633CC")
    parking.removeVehicle("B222BBB")
    parking.listVehicle()
    parking.showInfo()
}

