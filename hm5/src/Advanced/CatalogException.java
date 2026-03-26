package Advanced;

public class CatalogException extends Exception {
    public CatalogException(String message) {
        super(message);
    }

    // constructor pentru exceptii cauzate de alte erori
    public CatalogException(String message, Throwable cause) {
        super(message, cause);
    }
}