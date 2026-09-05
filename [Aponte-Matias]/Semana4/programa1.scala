case class Libro(titulo: String, autor: String, paginas: Int)

object main {

  def filtrarLibros(libros: List[Libro])(criterio: Libro => Boolean): List[Libro] = {
    libros.filter(criterio)
  }

  
  def formatearLibros(libros: List[Libro])(formato: Libro => String): List[String] = {
    libros.map(formato)
  }

  def calcularTotalCaracteres(titulos: List[String]): Int = {
    titulos.foldLeft(0)((acumulador, texto) => acumulador + texto.length)
  }

  def main(args: Array[String]): Unit = {
    val biblioteca = List(
      Libro("El principito", "Antoine de Saint-Exupéry", 102),
      Libro("Cien años de soledad", "Gabriel García Márquez", 981),
      Libro("La metamorfosis", "Franz Kafka", 123),
      Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 200),
      Libro("El viejo y el mar", "Ernest Hemingway", 97)
    )
    //Funciones
    val esLecturaCorta: Libro => Boolean = libro => libro.paginas < 200

    val formatearTitulo: Libro => String = libro => s"LECTURA CORTA: ${libro.titulo.toUpperCase}"

    val librosCortos = filtrarLibros(biblioteca)(esLecturaCorta)
    val reporteTitulos = formatearLibros(librosCortos)(formatearTitulo)
    val totalCaracteres = calcularTotalCaracteres(reporteTitulos)

    println("Reporte")
    reporteTitulos.foreach(println)
    println(s"\nTotal de caracteres: $totalCaracteres")
  }
}