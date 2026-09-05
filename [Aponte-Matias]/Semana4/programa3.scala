object Ejercicio3Semana4 {

  def procesarCatalogo[A, B](catalogo: Map[String, Double])(
    filtro: (String, Double) => Boolean,
    aplicarDescuento: Double => Double,
    formateador: (String, Double) => String
  ): (List[String], Double) = {

    val filtrados = catalogo.filter { case (k, v) => filtro(k, v) }

    val conDescuento = filtrados.map { case (k, v) => (k, aplicarDescuento(v)) }

    val listaFinal = conDescuento.toList.map { case (k, v) => formateador(k, v) }

    val precios = conDescuento.values.toList
    // foldLeft para acumular la suma
    val sumaTotal = precios.foldLeft(0.0)((acum, p) => acum + p)
    val promedio = if (precios.nonEmpty) sumaTotal / precios.size else 0.0

    (listaFinal, promedio)
  }

  def main(args: Array[String]): Unit = {
    val productos = Map(
      "Teclado Mecanico" -> 120.00,
      "Mouse Pad"        -> 25.00,
      "Monitor 24''"     -> 180.00,
      "Cable HDMI"       -> 15.50,
      "Auriculares Pro"  -> 85.00
    )

    // funciones
    val esPrecioMayorA50: (String, Double) => Boolean = (_, precio) => precio > 50.00
    val descuento20Porciento: Double => Double = precio => precio * 0.80
    val formatoFila: (String, Double) => String = (nombre, rebaja) =>
      f"Producto: $nombre | Precio Rebajado: $$${rebaja}%.2f"

    val (lineas, promedio) = procesarCatalogo(productos)(
      esPrecioMayorA50,
      descuento20Porciento,
      formatoFila
    )

    println("Reporte")
    lineas.foreach(println)
    println(f"\nPrecio promedio de los productos resultantes: $$${promedio}%.2f")
  }
}