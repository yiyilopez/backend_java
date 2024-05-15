package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;

public interface CulturemediaService {

    List<Video> findAll() throws VideoNotFoundException;
    Video add(Video video);
    View addView(View view); 
    List<Video> findByTitle(String title) throws VideoNotFoundException;
    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
    
}
