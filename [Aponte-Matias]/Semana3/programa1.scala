case class Libro(titulo: String, autor: String, paginas: Int)

object main {

  def generarReporteLecturasRapidas(libros: List[Libro]): (List[String], Int) = {
    // Libros con menos de 200 pag
    val librosCortos = libros.filter(libro => libro.paginas < 200)

    // Títulos en mayúsculas
    val titulosMayu = librosCortos.map(libro => s"LECTURA CORTA: ${libro.titulo.toUpperCase}")

    // Conteo caracteres 
    val totalCaracteres = titulosMayu.map(_.length).sum

    (titulosMayu, totalCaracteres)
  }

  def main(args: Array[String]): Unit = {
    val biblioteca = List(
      Libro("El principito", "Antoine de Saint-Exupéry", 90),
      Libro("Cien años de soledad", "Gabriel García Márquez", 501),
      Libro("La metamorfosis", "Franz Kafka", 200),
      Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 821),
      Libro("El viejo y el mar", "Ernest Hemingway", 123)
    )

    val (reporte, totalCaracteres) = generarReporteLecturasRapidas(biblioteca)

    println("Reporte")
    reporte.foreach(println)

    println(s"\nTotal de caracteres combinados: $totalCaracteres")
  }
}