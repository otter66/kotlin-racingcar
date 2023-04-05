package controller

import car.Cars
import view.InputView
import view.OutputView

class Controller(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun run() {
        val cars: Cars = inputView.readCars()
        val tryCount: Int = inputView.readTryCount()
        runTries(cars, tryCount)
        outputView.printWinners(cars.getWinners())
    }

    private fun runTries(cars: Cars, tryCount: Int) {
        repeat(tryCount) {
            cars.moveRandomForward()
            outputView.printTryResult(cars)
        }
    }
}
