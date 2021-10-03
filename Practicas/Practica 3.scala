var lista = Lista("rojo", "blanco", "negro")

lista = lista.appendedAll(Lista("verde" ,"amarillo", "azul", "naranja", "perla"))

val subLista = lista.slice(3, 6)
lista = lista.filter(n => !subLista.contains(n))

val arreglo = Range(1, 1_000, 5).toArray

val unico = Lista(1,3,3,4,6,7,3,7).toSet

val map = collection.mutable.Map( ( "Jose", 20), ("Luis", 24), ("Ana", 23),
("Susana", "27"))
print(map.keys)

map += ("Miguel" -> 23)