import MyMath.EquationsCalculator
import MyMath.FunctionsCalculator
import java.lang.Exception
import java.lang.NumberFormatException

//функція main, яка є точкою початку роботи програми.
fun main() {
    //за допомогою стандартної функції виведення print виводимо допоміжний текст,
    //щоб користувач точно зрозумів, що відбувається
    print("Enter 6 numbers separated by a space: ")
    //за допомогою стандартної функції введення отримуємо від користувача дані
    val input = readln()
    //через можливість некоректних даних, їх обробку та подальше використання
    //виносимо в блок try catch для перехоплення помилок
    try {
        //за допомогою функції split розбиваємо те, що ввів користувач по пробілам
        //у список
        val numbers = input.split(' ')

        //намагаємося привести рядки до типу Double за допомогою функції toDouble
        val a = numbers[0].toDouble()
        println("a = $a")
        val b = numbers[1].toDouble()
        println("b = $b")
        val c = numbers[2].toDouble()
        println("c = $c")
        val d = numbers[3].toDouble()
        println("d = $d")
        val x = numbers[4].toDouble()
        println("x = $x")
        val y = numbers[5].toDouble()
        println("y = $y")

        println("\nFUNCTION VALUES:")
        //виводимо максимальне значення для чисел, підставивши наші параметри
        println("\ny = MAX(a, b, c, d)")
        println("y = ${FunctionsCalculator.GetMax(a, b, c, d)}")

        //виводимо значення числа в 4 степені, підставивши наші параметри
        println("\ny = x^4")
        println("y = ${FunctionsCalculator.GetPowerOfNumber(x, 4)}")

        //виводимо значення квадратичної функції, підставивши наші параметри
        println("\ny = ax^2 + bx + c")
        println("y = ${FunctionsCalculator.GetQuadraticFunctionValue(x, a, b, c)}")

        println("\nEQUATIONS:")
        //виводимо корені рівняння 4 степеню, підставивши наші параметри
        println("\ny = x^4")
        println("roots = ${EquationsCalculator.getFourthPowerEquationRoots(y)}")

        //виводимо корені квадратного рівняння, підставивши наші параметри
        println("\ny = ax^2 + bx + c")
        println("roots = ${EquationsCalculator.getSquareEquationRoots(a, b, c - y)}")

        //виводимо корені лінійного рівняння, підставивши наші параметри
        println("\ny = ax + c")
        println("roots = ${EquationsCalculator.getLinearEquationRoot(a, c - y)}")
    }
    //виводимо помилку на екран, якщо така відбулась. Підбираєио текст в залежності від типу помилки
    catch (e: NumberFormatException) {
        println("You need to enter only numbers")
    }
    catch (e: ArrayIndexOutOfBoundsException) {
        println("You need to enter 6 numbers")
    }
    catch (e: Exception) {
        println(e)
    }
}
