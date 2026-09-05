import scala.io.StdIn.readLine
object main{
    def verificarStock(cantidades: List[Int], umbral: Int): Unit = {
    val iterador = cantidades.iterator

    while (iterador.hasNext) {
      val cantidad = iterador.next()
      if (cantidad < umbral) {
        println(s"Cantidad: $cantidad = La cantidad es poca se reposicion inmediata.")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val stockActual = List(50, 12, 5, 80, 2, 35)

    print("Ingrese el valor del umbral: ")
    val umbral = readLine().toInt

    verificarStock(stockActual, umbral)
  }
}
