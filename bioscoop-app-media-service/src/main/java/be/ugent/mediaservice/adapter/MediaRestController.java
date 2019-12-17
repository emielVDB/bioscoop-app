package be.ugent.mediaservice.adapter;

import be.ugent.mediaservice.domain.Media;
import be.ugent.mediaservice.persistence.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("media")
@CrossOrigin(origins = "*")
public class MediaRestController {
    @Autowired
    MediaRepository mediaRepository;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id)
    {
        Optional<Media> media= mediaRepository.findById(id);
        if (media.isPresent()){
            return ResponseEntity.ok(media.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No media with id '"+id+"'");
        }
    }

    //via -> http://127.0.0.1:2225/media/joker
    @GetMapping("/title/{title}")
    public Iterable<Media> getByDay(@PathVariable("title") String title)
    {
        return mediaRepository.getMediasByTitle(title);
    }

    @PostMapping()
    public ResponseEntity postMedia(@RequestBody Media media){
        Media newMed = mediaRepository.save(media);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMed);
    }

    //via -> http://127.0.0.1:2225/media
    @PostMapping("/{mediaId}")
    //public Iterable<Media> postMedia(@RequestBody Media media)
    public ResponseEntity postMediaFile(@PathVariable("mediaId") String mediaId, @RequestParam("file") MultipartFile file, @RequestParam("name") String name)
    {
        Optional<Media> optMedia= mediaRepository.findById(mediaId);
        if (!optMedia.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No media with id '"+mediaId+"'");
        }
        Media media = optMedia.get();

        //IMPLEMENT: UPLOAD FILE to gcs
        String url = "http://googleStorage/bucket/"+file.getOriginalFilename();
        media.getProperties().put(name, url);
        mediaRepository.save(media);

        return ResponseEntity.status(HttpStatus.CREATED).body(media);
    }

}
