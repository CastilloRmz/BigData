def CRadio(radio:Double): Double = {radio - 10}
val diametro = 20
scala> def CRadio(radio:Double): Double = {radio - 10}
CRadio: (radio: Double)Double

scala> val diametro = 20
diametro: Int = 20

scala> def NumPrimo(num:Int):Boolean = {Range(2, num).map(n => num % n !=
     | 0).reduce((a,b) => a && b)}
NumPrimo: (num: Int)Boolean

scala> var bird = "tweet"
bird: String = tweet

scala> var mensaje = "Hola Luke yo soy tu padre!"
mensaje: String = Hola Luke yo soy tu padre!

var mensaje = "Hola Luke yo soy tu padre!"
print("\n")
print(mensaje.slice(mensaje.indexOf(" ") + 1, mensaje.indexOf(" ", mensaje.indexOf("
") + 1), ))

The variable with "val" is constant and its value cannot change without declaring the
variable, on the other hand a value declared with "var" can be modified in
any moment.

scala> val tupla = (2, 4, 5, 1, 2, 3, 3.1416, 23)
tupla: (Int, Int, Int, Int, Int, Int, Double, Int) = (2,4,5,1,2,3,3.1416,23)

scala> print(s"\n${tupla._7}\n")

3.1416
