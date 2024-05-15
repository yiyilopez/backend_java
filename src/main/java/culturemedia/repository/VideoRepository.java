package culturemedia.repository;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;

public interface VideoRepository {
    List<Video> findAll() throws VideoNotFoundException;
    Video save(Video save);
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
    
}
