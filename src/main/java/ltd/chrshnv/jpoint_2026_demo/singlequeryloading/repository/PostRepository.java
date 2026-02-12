package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.repository;

import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, Long> {
}
