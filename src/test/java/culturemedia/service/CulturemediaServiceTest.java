package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.impl.CulturemediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CulturemediaServiceTest {
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;
    private CulturemediaService culturemediaService;
      private List<Video> videos;

    @BeforeEach
    void setUp() {
        videoRepository = mock(VideoRepository.class);
        viewsRepository = mock(ViewsRepository.class);
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewsRepository);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> videos = List.of(
                new Video("01", "Título 1", "Descripción 1", 4.5),
                new Video("02", "Título 2", "Descripción 2", 5.5)
        );
        when(videoRepository.findAll()).thenReturn(videos);

        List<Video> result = culturemediaService.findAll();

        assertEquals(2, result.size());
        assertEquals(videos, result);
    }
    
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException {
        when(videoRepository.findAll()).thenReturn(List.of());

        Executable executable = () -> culturemediaService.findAll();

        assertThrows(VideoNotFoundException.class, executable);
    } 

    @Test
    void find_by_title_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findByTitle("title"));
    }

    @Test
    void find_by_duration_video_exception() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findByDuration(0.0, 5.0));
    }

    @Test
    void find_by_title_video() throws VideoNotFoundException {
        String parameter = "Video";
        List<Video> expected = videos.stream().filter(p -> p.title().contains(parameter)).toList();
        doReturn(expected).when(videoRepository).find(parameter);

        List<Video> result = culturemediaService.findByTitle(parameter);
        assertTrue(result.containsAll(expected));
    }

    @Test
    void find_by_duration_video() throws VideoNotFoundException {
        List<Video> expected = videos.stream().filter(p -> p.duration() <= 5.0 && p.duration() >= 3.0).toList();
        doReturn(expected).when(videoRepository).find(3.0, 5.0);

        List<Video> result = culturemediaService.findByDuration(3.0, 5.0);
        assertTrue(result.containsAll(expected));
    }

}
