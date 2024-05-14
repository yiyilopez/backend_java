package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;

public interface CulturemediaService {

    List<Video> findAll() throws VideoNotFoundException;
    Video add(Video video);
    View addView(View view);   

}
