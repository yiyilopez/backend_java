package culturemedia.controllers;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturemediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/culturemedia")
public class CultureMediaController {

    private final CulturemediaService culturemediaService;

    @Autowired
    public CultureMediaController(CulturemediaService cultureMediaService) {
        this.culturemediaService = cultureMediaService;
    }

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> findAllVideos() {
        try {
            List<Video> videos = culturemediaService.findAll();
            return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (VideoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/videos")
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        Video savedVideo = culturemediaService.add(video);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    @GetMapping("/videos/title/{title}")
    public ResponseEntity<List<Video>> findVideosByTitle(@PathVariable String title) {
        try {
            List<Video> videos = culturemediaService.findByTitle(title);
            return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (VideoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/videos/duration")
    public ResponseEntity<List<Video>> findVideosByDuration(@RequestParam Double from, @RequestParam Double to) {
        try {
            List<Video> videos = culturemediaService.findByDuration(from, to);
            return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (VideoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
