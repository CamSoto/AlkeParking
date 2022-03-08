fun main(args: Array<String>) {
    val car = Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")
    val motorcycle = Vehicle("B222BBB", VehicleType.MOTORCYCLE)
    val minibus = Vehicle("CC333CC", VehicleType.MINIBUS)
    val bus = Vehicle("DD444DD", VehicleType.BUS, discountCard = "DISCOUNT_CARD_002")
    val parking = Parking(mutableSetOf(car, motorcycle, minibus, bus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(motorcycle))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))
    parking.vehicles.remove(motorcycle)
    println(parking.vehicles.size)
}

