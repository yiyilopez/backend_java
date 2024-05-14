package culturemedia.exception;

public class VideoNotFoundException extends CulturemediaException {
    public VideoNotFoundException() {
        super("Video not found");
    }


public VideoNotFoundException(String title){
    super("Video with title " + title + " is invalid. Please enter a valid title.");
}  
}
