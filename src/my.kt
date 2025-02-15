import java.util.*

class Ca(val brand: String, val model: String, val price: Double)

class Buye(val name: String, var balance: Double) {
    var ownedCar = mutableListOf<Ca>()

    fun buy(car: Ca) {
        if (balance >= car.price) {
            balance -= car.price
            ownedCar.add(car)
            println("You owned the car: ${car.brand} ${car.model}")
        } else {
            println("You cannot buy this car")
        }
    }

    fun ownCars() {
        if (ownedCar.isEmpty()) {
            println("Your car collection is empty")
        } else ownedCar.forEach {
            println("${it.brand}, ${it.model}, ${it.price}")
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter your name:")
    val userName = scanner.nextLine()

    println("How many cars do you want to buy?")
    val numCars = scanner.nextInt()

    println("Enter your budget:")
    val userBudget = scanner.nextDouble()

    val cars = listOf(
        Ca("Audi", "A6", 1000000.0),
        Ca("Volkswagen", "Polo", 500000.0),
        Ca("BMW", "M6", 900000.0),
        Ca("Mercedes", "C-Class", 850000.0),
        Ca("Tesla", "Model S", 1200000.0),
        Ca("Ford", "Mustang", 950000.0),
        Ca("Toyota", "Supra", 980000.0),
        Ca("Honda", "Civic", 600000.0),
        Ca("Nissan", "GTR", 1300000.0),
        Ca("Chevrolet", "Camaro", 920000.0)
    )

    val buyer = Buye(userName, userBudget)

    val affordableCars = cars.filter { it.price <= buyer.balance }.sortedBy { it.price }

    if (affordableCars.size < numCars) {
        println("You cannot buy $numCars cars with your budget.")
        return
    }

    val totalCost = affordableCars.take(numCars).sumOf { it.price }
    if (totalCost > userBudget) {
        println("You cannot buy $numCars cars within your budget of $userBudget.")
        return
    }

    println("These are the cars you can buy:")
    affordableCars.forEachIndexed { index, car ->
        println("${index + 1}. ${car.brand} ${car.model} - ${car.price}")
    }

    repeat(numCars) {
        println("Enter the number of the car you want to buy:")
        val choice = scanner.nextInt() - 1
        if (choice in affordableCars.indices) {
            buyer.buy(affordableCars[choice])
        } else {
            println("Invalid choice")
        }
    }

    println("Owned Cars:")
    buyer.ownCars()

    println("Current balance: ${buyer.balance}")
}
