package MyMath

//клас для розрахунку значень функцій
class FunctionsCalculator {
    //декілька об'єктів цього класу не потрібно тому можна зробити функції статичними
    companion object {
        //функція для розрахунку максимального значення з набору
        //vararg дозволяє викликати функцію з будь-яким числом параметрів
        //і використовувати їх всередині як список. Для запобігання 0 аргументів,
        //був доданий ще один обов'язковий
        fun GetMax(number1: Double, vararg otherNumbers: Double) : Double {
            //спочатку приймаємо перше значення за найбільше
            var max = number1
            //в цій функції вивиедення відбувається пізніше і формується
            //під час виконання у рядку, значення якого потім виводиться на екран
            var message = "$max"
            //проходимо в циклі додаткові аргументи і знаходимо найбільший,
            //що записуєтсья в змінну max
            for (number in otherNumbers) {
                //додамо значення в рядок
                message += " ${number}"
                if (number > max) {
                    max = number
                }
            }
            println("Calculating max of $message")
            return max
        }

        //функція для піднесення цисла до цілого степеню
        fun GetPowerOfNumber(number: Double, power: Int) : Double {
            println("Calculating $number ^ $power")
            //початкове значення - 1
            var result = 1.0
            //якщо степінь від'ємний, ділимо на число
            if (power < 0) {
                for (pow in power..-1) {
                    result /= number
                }
            }
            //якщо степінь додатний множимо на число, починаючи зі степеню 1
            else {
                for (pow in 1..power) {
                    result *= number
                }
            }
            //повертаємо отриманий результат
            return result
        }

        //функція обчислення значення квадратичної функції
        fun GetQuadraticFunctionValue(argument: Double, coeficient1: Double, coeficient2: Double, coeficient3: Double) : Double {
            println("Claculating function y = ${coeficient1}x^2 + ${coeficient2}x + $coeficient3    x = $argument")
            //повертаємо значення функції. Цього разу було використано свою функцію піднесення до степеня замість стандартної
            return coeficient1 * GetPowerOfNumber(argument, 2) + coeficient2 * argument + coeficient3
        }
    }
}