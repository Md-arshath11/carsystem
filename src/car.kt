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

    println("Enter your Balance")
    val balance = scanner.nextDouble()

    val buyer = Buyer1(name, balance)

    println("enter car")
    val cars= mutableListOf<Cars>()

    for (i in 1..3){
        println("Enter car $i")
        println("Enter brand name")
        val brand = scanner.nextLine()

        println("Enter model name")
        val model = scanner.nextLine()

        println("Enter price ")
        val price = scanner.nextDouble()

        cars.add(Cars(brand,model, price))

    }

    println("Available cars:")
    cars.forEachIndexed{ index,car ->
        println("${index+1}.${car.brand}.${car.model}")
    }

    println("enter the car that you want to buy:")
    val choices= scanner.nextInt()

    if (choices in 1..cars.size) {
        buyer.buy(cars[choices-1])
    }else{
        println("invalid choices")
    }

    buyer.ownCars()


}