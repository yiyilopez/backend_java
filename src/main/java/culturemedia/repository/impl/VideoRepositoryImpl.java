package culturemedia.repository.impl;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

public class VideoRepositoryImpl implements VideoRepository{
    List<Video> videos = new ArrayList<>();
   
    @Override
    public List<Video> findAll() {
        return new ArrayList<>(videos);
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
