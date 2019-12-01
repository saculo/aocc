package day01

import utils.FileReader

import scala.annotation.tailrec

object Solution {
  def part1(): Double = {
    var input = FileReader.getInput("path")
    var sum: Double = countFuel1(input)
    println(sum)

    sum
  }

  def part2(): Double = {
    var input = FileReader.getInput("path")

    var sum: Double = input
      .map(x => x.toDouble)
      .map(x => countFuel2(x))
      .sum
    println(sum.toLong)
    sum
  }


  private def countFuel1(input: Seq[String]) = {
    var sum = input.map(x => x.toDouble)
      .map(y => fuelFormula(y))
      .sum
    sum
  }

  def countFuel2(mass: Double): Double = {
    @tailrec def countFuel(sum: Double, fuel: Double): Double = {
      if (fuel == 0)
        sum
      else {
        val current = fuelFormula(fuel) max 0
        countFuel(sum + current, current)
      }
    }

    countFuel(0, mass)
  }

  private def fuelFormula(y: Double) = {
    math.floor(y / 3.0) - 2
  }
}
