package culturemedia.repository.impl;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VideoRepositoryImpl implements VideoRepository{
    private final List<Video> videos = new ArrayList<>();
   
    @Override
    public List<Video> findAll() {
        return videos;
    }

    @Override
    public Video save(Video video) {
        videos.add(video);
        return video;
    }


    @Override
    public List<Video> find(String title) {
        return videos.stream()
                .filter(video -> video.title().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        return videos.stream()
                .filter(video -> video.duration() >= fromDuration && video.duration() <= toDuration)
                .collect(Collectors.toList());
    }
}
