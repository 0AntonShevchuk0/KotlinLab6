package MyMath

import java.lang.Exception

//клас для обчислювання рівнянь
class EquationsCalculator {
    //декілька об'єктів цього класу не потрібно тому можна зробити функції статичними
    companion object {
        //функція знаходження коренів простого рівняння 4 степеню x^4
        fun getFourthPowerEquationRoots(coeficient : Double) : List<Double> {
            //число в 4 степені не може бути від'ємним, тому створюємо виключну ситуацію
            //типу ArithmeticException з текстом "Number < 0"
            if (coeficient < 0) {
                throw Exception("Number < 0")
            }
            println("Calculating equation x^4 = $coeficient")
            //знаходимо корінь без знаку за допомогою функції pow математичної бібліотеки Math,
            //підносячи число coeficient до степеню 0.25
            val rootValue = Math.pow(coeficient, 0.25)
            //якщо корінь 0, не повторюємо його
            //повертаємо новий список
            if (rootValue == 0.0) {
                return listOf(rootValue)
            }
            return listOf(rootValue, -rootValue)
        }

        //функція знаходження коренів квадратного рівняння ax^2 + bx + c = 0
        fun getSquareEquationRoots(coeficient1 : Double, coeficient2: Double, coeficient3: Double) : List<Double> {
            println("Calculating equation ${coeficient1}x^2 + ${coeficient2}x + $coeficient3 = 0")
            if (coeficient1 == 0.0) {
                throw Exception("Division by zero. This is not square equation")
            }
            //обчислюємо дескримінант по шкільній формулі
            val descriminant = Math.pow(coeficient2, 2.0) - 4.0 * coeficient1 * coeficient3
            //якщо дескримінант менше 0, створюєио виключну ситуацію
            //типу ArithmeticException з текстом "Descriminant < 0"
            if (descriminant < 0) {
                throw Exception("Descriminant < 0")
            }
            //обчислюємо корені по шкільній формулі, враховуємо можливість 1 кореня
            if (descriminant == 0.0) {
                return listOf((-coeficient2 + Math.sqrt(descriminant)) / (2.0 * coeficient1))
            }
            val root1 = (-coeficient2 + Math.sqrt(descriminant)) / (2.0 * coeficient1)
            val root2 = (-coeficient2 - Math.sqrt(descriminant)) / (2.0 * coeficient1)
            //повертаємо новий список
            return listOf(root1, root2)
        }

        //функція знаходження коренів лінійного рівняння
        fun getLinearEquationRoot(coeficient1 : Double, coeficient2: Double) : Double {
            println("Calculating equation ${coeficient1}x + ${coeficient2} = 0")
            //перевірка ділення на 0
            if (coeficient1 == 0.0) {
                throw Exception("Division by zero")
            }
            //перевірка нескінченної кількості коренів
            if (coeficient2 == 0.0) {
                throw Exception("Infinite number of roots")
            }
            //знаходимо корінь по шкільній формулі
            return -coeficient2 / coeficient1
        }
    }
}