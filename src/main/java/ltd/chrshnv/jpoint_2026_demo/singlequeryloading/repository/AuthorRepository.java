package ltd.chrshnv.jpoint_2026_demo.singlequeryloading.repository;

import ltd.chrshnv.jpoint_2026_demo.singlequeryloading.entity.Author;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface AuthorRepository extends ListCrudRepository<Author, UUID> {
}
