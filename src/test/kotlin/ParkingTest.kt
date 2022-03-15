import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

internal class ParkingTest {

    private val testParking : Parking = Parking(mutableSetOf())

    @Before
    fun setup() {
        val arrayVehicles: Array<Vehicle> = arrayOf(
            Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001"),
            Vehicle("B222BBB", VehicleType.MOTORCYCLE),
            Vehicle("CC333CC", VehicleType.MINIBUS),
            Vehicle("AM111AA", VehicleType.CAR)
        )
        for (i in arrayVehicles){
            testParking.addVehicle(i)
        }
    }

    @Test
    fun addVehicleTestPassed1() =
        assertEquals(true, testParking.addVehicle(Vehicle("AA101AA", VehicleType.CAR)))

    @Test
    fun addVehicleTestPassed2() =
        assertEquals(true, testParking.addVehicle(Vehicle("AA101AA", VehicleType.CAR, discountCard = " ")))

    @Test
    fun addVehicleTestPassed3() =
        assertEquals(true, testParking.addVehicle(Vehicle("AA101AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_009")))

    @Test
    fun addVehicleTestFailed1() =
        assertEquals(false, testParking.addVehicle(Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001")))

    @Test
    fun addVehicleTestFailed2() =
        assertEquals(false, testParking.addVehicle(Vehicle("B222BBB", VehicleType.MOTORCYCLE)))

}