package culturemedia.exception;

public class CulturemediaException extends Exception{
    public CulturemediaException(String message) {
        super(message);
}

public CulturemediaException(String message, Throwable cause) {
    super(message, cause);
}

}