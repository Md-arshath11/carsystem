import java.util.*

class Cars(val brand: String, val model: String, val price:Double)


class Buyer1(val name: String, var balance: Double) {

    var ownedCar = mutableListOf<Cars>()

    fun buy(car: Cars) {
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
    val scanner = Scanner(System.`in`)

    println("Enter your name: ")
    val name = scanner.nextLine()

    println("How many cars do you want to buy ")
    val numberOfCars = scanner.nextInt()

    println("Enter your Budget")
    val budget = scanner.nextDouble()

    val cars = listOf(
        Cars("Audi", "A6", 1000000.0),
        Cars("Volkswagen", "Polo", 500000.0),
        Cars("BMW", "M6", 900000.0),
        Cars("Mercedes", "C", 850000.0),
        Cars("Tesla", "S", 1200000.0),
        Cars("Ford", "Mustang", 950000.0),
        Cars("Toyota", "Supra", 980000.0),
        Cars("Honda", "Civic", 600000.0),
        Cars("Nissan", "GTR", 1300000.0),
        Cars("Chevrolet", "C", 920000.0)
    )

    val buyer = Buyer1(name,budget)

    val affordableCars = cars.filter { it.price <= buyer.balance}

    if (affordableCars.size < numberOfCars) {
        println("You can't buy this car")
        return
    }

    val cost= affordableCars.take(numberOfCars).sumOf { it.price }
    if (cost>budget){
        println("You can't buy this car")
        return
    }

    println("Available cars:")
    cars.forEachIndexed{ index,car ->
        println("${index+1}.${car.brand}.${car.model}")
    }

    for (i in 1..numberOfCars) {
        println("enter the car you want to buy")
        val choice=scanner.nextInt()
        if(choice in affordableCars.indices){
            buyer.buy(affordableCars[choice])
        }else{
            println("You can not buy this car")
        }
    }

    println("owned cars")
    buyer.ownCars()


}