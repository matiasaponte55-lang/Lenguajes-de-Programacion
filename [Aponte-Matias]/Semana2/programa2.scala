import scala.io.StdIn.readLine
object main {
    def buscarProducto(catalogo: Map[String, Double], productoB: String): Unit = {
    val iterador = catalogo.iterator
    var encontrado = false

    while (iterador.hasNext && !encontrado) {
      val (producto, precio) = iterador.next()
      if (producto.equalsIgnoreCase(productoB)) {
        println(s"El precio de $producto es $$$precio")
        encontrado = true
      }
    }

    if (!encontrado) {
      println("Producto no encontrado")
    }
  }

  def main(args: Array[String]): Unit = {
    val catalogo = Map(
      "Arroz" -> 4.50,
      "Aceite" -> 8.20,
      "Leche" -> 3.80,
      "Azucar" -> 3.20
    )

    print("Ingrese el nombre del producto: ")
    val buscado = readLine()

    buscarProducto(catalogo, buscado)
  }
}
