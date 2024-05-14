package culturemedia.exception;

public class DurationNotValidException extends CulturemediaException {
    public DurationNotValidException(String title, Double Duration){
        super("Duration " + Duration + " of video with title " + title + " is not valid");
    }

}
