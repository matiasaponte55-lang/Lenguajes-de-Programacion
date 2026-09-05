object Ejercicio2Semana4 {

  def procesarEtiquetas(etiquetas: Set[String])(
    transformador: String => String,
    validador: String => Boolean
  ): String = {
    etiquetas
      .map(transformador)
      .filter(validador)
      .reduceOption((a, b) => s"$a, $b")
      .getOrElse("")
  }

  def main(args: Array[String]): Unit = {
    val tagsEntrada = Set(" Scala ", "scala", "SCALA", " AI", "code", "dev", "  jvm  ", "js", "  ", "programacion")
    //Funciones
    val limpiarEspacios: String => String = _.trim
    val convertirMinuscula: String => String = _.toLowerCase
    val nTag: String => String = limpiarEspacios.andThen(convertirMinuscula)

    // Longitud
    val longitudValida: String => Boolean = tag => tag.length >= 3

    val resultado = procesarEtiquetas(tagsEntrada)(nTag, longitudValida)

    println("Hashtag")
    println(resultado)
  }
}