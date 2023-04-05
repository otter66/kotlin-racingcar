package view

import car.Cars
import car.ForwardCount

class OutputView {

    fun printTryResult(cars: Cars) {
        println("실행 결과")
        cars.values.forEach {
            val name: String = it.name.toString()
            val forwardStateForm: String = getForwardStateForm(it.forwardCount)
            println("$name : $forwardStateForm")
        }
        println()
    }

    fun printWinners(cars: Cars) {
        print("최종 우승자: ")
        cars.values.forEachIndexed { index, car ->
            val name: String = car.name.toString()
            val delimiter: String = if (index != cars.values.lastIndex) ", " else ""
            print("$name$delimiter")
        }
    }

    private fun getForwardStateForm(forwardCount: ForwardCount): String {
        val stringBuilder: StringBuilder = StringBuilder()
        repeat(forwardCount.toInt()) { stringBuilder.append("-") }
        return stringBuilder.toString()
    }
}