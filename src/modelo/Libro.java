package modelo;

public class Libro {
   private String titulo;
   private String nombreAutor;
   private String editorial;
   private int numeroPaginas;
   private float precio;
   private int ISBN;

    public Libro() {
    }
    
    public Libro(String titulo) {
        this.titulo = titulo;
    }
    
    
    
    public Libro(String titulo, String nombreAutor, String editorial, int numeroPaginas, float precio, int ISBN) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
