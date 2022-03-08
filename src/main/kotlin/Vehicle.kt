import java.util.*

data class Vehicle (val plate: String, val type: VehicleType, val checkInTime: Calendar = Calendar.getInstance(), val discountCard: String? = null){

    //Function states that two Vehicles are equal if their plates are equal
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }
    //Function states that the hashcode (Used internally in search functions
    //in sets and arrays)
    override fun hashCode(): Int = this.plate.hashCode()
}

