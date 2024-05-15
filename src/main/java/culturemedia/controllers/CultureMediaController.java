package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.impl.CulturemediaServiceImpl;

public class CultureMediaController {

    private final CulturemediaServiceImpl culturemediaService; 
    public CultureMediaController(CulturemediaServiceImpl culturemediaService) {
        this.culturemediaService = culturemediaService; 
    }

    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = culturemediaService.findAll();
        videos = culturemediaService.findAll();
        return videos;
    }
}
