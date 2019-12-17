package be.ugent.mediaservice.persistence;

import be.ugent.mediaservice.domain.Media;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MediaRepository extends MongoRepository<Media, String> {

    @Query("{ 'title' : { $regex: ?0 } }")
    List<Media> getMediasByTitle(String title);
}
