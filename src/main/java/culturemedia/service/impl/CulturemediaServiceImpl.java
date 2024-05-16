package culturemedia.service.impl;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CulturemediaService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CulturemediaServiceImpl implements CulturemediaService {
    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturemediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

        public CulturemediaServiceImpl(){
        this.videoRepository = new VideoRepositoryImpl();
        this.viewsRepository = new ViewsRepositoryImpl();
    }

    @Override
    public List<Video> findAll(){
        List<Video> videos = videoRepository.findAll();
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

    @Override
    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.find(title);
        return videos;
    }

    @Override
    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> videos = videoRepository.find(fromDuration, toDuration);

        return videos;
    }

}