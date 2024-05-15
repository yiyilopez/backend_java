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
import static org.mockito.Mockito.*;

class CulturemediaServiceTest {
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;
    private CulturemediaService culturemediaService;

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
    
}
