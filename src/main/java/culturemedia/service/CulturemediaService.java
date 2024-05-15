package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;

public interface CulturemediaService {

    List<Video> findAll() throws VideoNotFoundException;
    Video add(Video video);
<<<<<<< HEAD
    View addView(View view); 
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
    
=======
    View addView(View view);
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;   
>>>>>>> 257c5cb2a5d801f4fa91f009ea7293723221f15b
}

//Así está bien
