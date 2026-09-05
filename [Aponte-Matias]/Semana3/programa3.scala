object main {

  def actualizarPrecios(catalogo: Map[String, Double]): (List[String], Double) = {
    // Mayores a 50
    val productosFiltrados = catalogo.filter { case (_, precio) => precio > 50.00 }

    // Descuento 20%
    val productosConDescuento = productosFiltrados.map { case (nombre, precio) => (nombre, precio * 0.80)}

    val listaFormateada = productosConDescuento.toList.map { case (nombre, precioRebajado) =>
      f"Producto: $nombre | Precio Rebajado: $$${precioRebajado}%.2f"
    }

    // Promedio
    val preciosRebaja = productosConDescuento.values.toList
    val promedio = if (preciosRebaja.nonEmpty) preciosRebaja.sum / preciosRebaja.size else 0.0

    (listaFormateada, promedio)
  }

  def main(args: Array[String]): Unit = {
    val productos = Map(
      "Teclado Mecanico" -> 120.00,
      "Mouse 2" -> 25.00,
      "Monitor 25 pulgadas" -> 180.00,
      "Cable HDMI" -> 15.50,
      "Audifonos" -> 85.00
    )

    val (reporteProductos, precioPromedio) = actualizarPrecios(productos)

    println("Actualizacion de productos")
    reporteProductos.foreach(println)

    println(f"\nPrecio promedio de los productos en rebaja: $$${precioPromedio}%.2f")
  }
}