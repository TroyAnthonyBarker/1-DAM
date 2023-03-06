public class Libro {
    private String titulo, autor, ISBN;

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        if (compruebaisbn10(ISBN) || compruebaisbn13(ISBN)) {
            this.ISBN = ISBN;
        } else {
            System.err.println("ISBN no válido");
            this.ISBN = null;
        }
    }

    private boolean compruebaisbn10(String isbn) {
        int[] numIsbn = new int[isbn.length()];
        int suma = 0;
        if (isbn.length() == 10) {
            for (int i = 0; i < isbn.length(); i++) {
                numIsbn[i] = Character.getNumericValue(isbn.charAt(i));
            }
            for (int i = 0; i < numIsbn.length; i++) {
                suma += numIsbn[i] * (i + 1);
            }
            return suma % 11 == 0;
        } else {
            return false;
        }
    }

    public boolean compruebaisbn13(String isbn) {
        int[] numIsbn = new int[isbn.length()];
        int suma = 0;
        if (isbn.length() == 13) {
            for (int i = 0; i < isbn.length(); i++) {
                numIsbn[i] = Character.getNumericValue(isbn.charAt(i));
            }
            for (int i = 0; i < numIsbn.length - 1; i++) {
                if (numIsbn[i] % 2 == 0) {
                    suma += numIsbn[i] * 3;
                } else {
                    suma += numIsbn[i];
                }
            }
            return 10 - (suma % 10) == numIsbn[numIsbn.length - 1];
        } else {
            return false;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if (compruebaisbn10(ISBN) || compruebaisbn13(ISBN)) {
            this.ISBN = ISBN;
        } else {
            System.err.println("ISBN no válido (ISBN no modificado)");
        }
    }

    public String getInfo() {
        return titulo + " escrito por " + autor + " con ISBN: " + ISBN;
    }
}
