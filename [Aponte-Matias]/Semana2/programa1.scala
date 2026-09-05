import scala.io.StdIn.readLine

object main {
  def verificarTemperaturas(temperaturas: List[Int]): Unit = {
    print("Ingresar la temperatura mínima segura: ")
    val minSeguro = readLine().toInt

    print("Ingresar la temperatura máxima segura: ")
    val maxSeguro = readLine().toInt

    val iterador = temperaturas.iterator
    var alertaEstabilidad = false

    println("\nTemperaturas fuera de rango que han sido detectadas:")
    while (iterador.hasNext) {
      val temp = iterador.next()
      if (temp < minSeguro || temp > maxSeguro) {
        println(s" Temperatura crítica: ${temp}°C")
        alertaEstabilidad = true
      }
    }

    if (alertaEstabilidad) {
      println("\nAlerta de estabilidad")
    }
  }

  def main(args: Array[String]): Unit = {
    val temps = List(10, 5, 30, 22, 50, 1, 25)
    verificarTemperaturas(temps)
  }
}