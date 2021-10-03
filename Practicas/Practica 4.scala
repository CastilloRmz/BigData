def fibonacci(f:Integer): Integer = {
if (f < 2) {return f} fibonacci(f - 1) + fibonacci(f - 2)}
val f = 23
print(s"\nEcuacion Fibonacci ($f) = ${fibonacci(f)}\n")

val FExplicita = (1 + math.sqrt(5)) / 2
def fibo2(f:Integer): Double = { if(f < 2){ return f.toDouble }
(math.pow(FExplicita, f.toDouble) - math.pow(1 - FExplicita, f.toDouble)) /
math.sqrt(5).toDouble}
print(s"\nSegunda ecuacion Fibonacci($f) = ${fibo2(f)}\n\n")

def fibon3(f:Integer): Integer = {var a = 0 var b = 1 var c: Integer = null
for (g <- Range(0, f)) {c = b + a a = b b = c } a}
print(s"\nTercera ecuacion Fibonacci($f) = ${fibon3(f)}\n\n")

def fibona4(f:Integer): Integer = { var a = 0 var b = 1
for (g <- Range(0, f)) { b = b + a a = b - a } a}
print(s"\nCuarta ecuacion Fibonacci($f) = ${fibona4(f)}\n\n")

def fibonacci5(f:Integer): Integer = {
if(f < 2){ return f }
val vector = collection.mutable.Seq.fill(f + 1)(0) vector(1) = 1
for (g <- Range(2, f + 1)) {vector(g) = vector(g - 1) + vector(g - 2) } vector(f) }
print(s"\nQuinta ecuacion Fubonacci($f) = ${fibonacci5(f)}\n\n")