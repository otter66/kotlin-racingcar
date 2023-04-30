package view

import domain.car.Cars

class InputView {

    fun readCars(): Cars {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputCarNames = readln()
        return Cars.from(inputCarNames.split(",").toList())
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputTryCount = readln()
        println()
        return inputTryCount.toInt()
    }
}
