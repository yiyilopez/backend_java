package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;

public interface CulturemediaService {

    List<Video> findAll() throws VideoNotFoundException;
    Video add(Video video);
    List<Video> find(String title) throws VideoNotFoundException;
    List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException;

}
