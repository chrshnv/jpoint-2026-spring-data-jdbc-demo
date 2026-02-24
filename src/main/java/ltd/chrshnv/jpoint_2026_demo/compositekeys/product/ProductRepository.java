package ltd.chrshnv.jpoint_2026_demo.compositekeys.product;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, ProductId> {
}
