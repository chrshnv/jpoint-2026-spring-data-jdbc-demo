package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.repository;

import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Photo;
import org.springframework.data.repository.ListCrudRepository;

public interface PhotoRepository extends ListCrudRepository<Photo, Long> {
}
