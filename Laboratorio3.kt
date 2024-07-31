// Diego Fabián Morales Dávila
// Carné: 23267
// Última modificación: 30/07/24


// Clase FOOD que será heredada en todas las subclases Hijas.
open abstract class Food(val name: String, var price: Int){
    open abstract fun Cook()
}

// Clase Burguer que hereda de FOOD.
class Burguer(name: String, price: Int): Food(name, price){
    override fun Cook() {
        return println("La hamburguesa: '${name}' se prepara en forma de torre con: pan de apertura, carne, queso, lechuga, salsas, pan de cierre.\n" + 
                "Tiene un costo de ${price} Quetzales")
    }
}


// Clase Pizza que hereda de FOOD.
class Pizza(name: String, price: Int): Food(name, price){
    override fun Cook() {
        return println("Para hacer la '${name}' se prepara la masa a 200°C, se prepara la salsa, se estíra la masa y se añade la salsa e ingredientes. Finalmente se hornea.\n" + 
                "Tiene un costo de ${price} Quetzales")
    }
}


interface Dessert{
    fun eat()
}


class IceCream(name: String, price: Int): Food(name, price), Dessert{
    override fun Cook() {
        return println("Para hacer el '${name}' se vierte leche, nata líquida, azúcar e ingrediente específico en fuego lento. Batir yemas de huevo y echar en .\n" + 
                "mezcla. Meter mezcla durante 30 minutos al congelador y sacar para romper los cristales de hielo.\n" +
                "Tiene un costo de ${price} Quetzales")
    }
    override fun eat(){
        println("Te has comido el ${name}.")
    }
}

abstract class Drink(name: String, price: Int): Food(name, price){
    abstract fun pour()
}

class Juice(name: String, price: Int): Drink(name, price){
    override fun pour(){
        println("Se vierte el ${name} en un vaso mediano de cualquier tipo.")
    }
    override fun Cook() {
        return println("Para hacer el '${name}' se exprime la fruta con exprimidor para que caiga el jugo dentro de nuestro pichel.\n" + 
                "Tiene un costo de ${price} Quetzales")
    }
}

// Función extensión de FOOD que obtiene el precio para aplicarle el descuento y devolver un string, aunque pude haber impreso el mensaje de una vez jaja.
fun Food.discountedPrice(descuento: Int): String {
    price = price - ((price * descuento)/100)
    return "Ahora tiene un costo de: ${price} Quetzales" 
}


// Clase MAIN para la implementación de las clases y métodos.
fun main() {
    
    val Hamburgruesa = Burguer("Hamburguesa de esta", 50)
    Hamburgruesa.Cook()
    
    val Peperonni = Pizza("Pizza de peperonni", 100)
    Peperonni.Cook()
    
    val Helado1 = IceCream("Helado de Fresa", 15)
    Helado1.eat()
    
    val Jugo_Na = Juice("Jugo de Naranja", 5)
    Jugo_Na.Cook()
    Jugo_Na.pour()
    
    
    val Helado2 = IceCream("Helado de Chocolate", 100)
    println(Helado2.discountedPrice(10))
    Helado2.Cook()
    

	
}