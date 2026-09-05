object main {

  def limpiarHashtags(etiquetas: Set[String]): String = {
    // Limpiar espacios y minúsculas
    val normalizadas = etiquetas.map(tag => tag.trim.toLowerCase)

    // Etiquetas con menos de 3 caracteres
    val validas = normalizadas.filter(tag => tag.length >= 3)

    validas.mkString(", ")
  }

  def main(args: Array[String]): Unit = {
    val tagsEntrada = Set("Scala", "lenguajes", "scala", "AI", "code", "dev", "jvm", "js", " ", "programacion")

    val resultado = limpiarHashtags(tagsEntrada)

    println("Hashtags procesados")
    println(resultado)
  }
}