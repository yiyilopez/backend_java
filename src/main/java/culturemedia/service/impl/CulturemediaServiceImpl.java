package culturemedia.service.impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturemediaService;

import java.util.List;


public class CulturemediaServiceImpl implements CulturemediaService {
    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturemediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found at this time.");
        }
        return videos;
    }

    @Override
    public Video add(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public View addView(View view) {
        return viewsRepository.add(view);
    }
}