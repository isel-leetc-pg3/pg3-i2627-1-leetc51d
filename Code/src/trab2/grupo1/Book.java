package trab2.grupo1;

public record Book(String title, String author, int year, String editor, String isbn, BookGenre genre) {
    /**
     * Verifica a igualdade entre este Book e o objeto recebido no parâmetro obj.
     * @param obj   referência do objeto a comparar.
     * @return true se os dois objetos tiverem o mesmo ISBN; false, caso contrário
     */
    public boolean equals(Object obj) {
        // ToDo
    }
    public int hashCode() {
        // ToDo
    }
}
