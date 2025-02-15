class Car(val brand: String, val model: String, val price: Double)


class Buyer(val name: String, var balance: Double) {

    var ownedCar = mutableListOf<Car>()

    fun buy(car: Car) {
        if (balance >= car.price) {
            balance -= car.price
            ownedCar.add(car)
            println("You owned the car")
        } else {
            println("You can not buy this car")
        }
    }

    fun ownCars() {
        if (ownedCar.isEmpty()) {
            println("you car collection is empty")
        } else ownedCar.forEach() {
            println("${it.brand},${it.model},${it.price}")

        }
    }
}

fun main(){
    val cars= listOf(Car("AUDI","A6",1000000.0),Car("Volkswagen","Polo",500000.0),Car("BMW","M6",900000.0))
    val buyer=Buyer("Arshath",5000000.0)

    println("Available cars:")
    cars.forEachIndexed{ index,car ->
        println("${index+1}.${car.brand}.${car.model}")
    }

    println("enter a car that you want to buy")
    val choice= readLine()?.toIntOrNull()?.minus(1)

    if(choice != null && choice in cars.indices) buyer.buy(cars[choice])
    else println("invalid choice")

    buyer.ownCars()

    println("Current balance: ${buyer.balance}")
//        println("Owned Cars:${buyer.ownedCar.toString()}")
}


