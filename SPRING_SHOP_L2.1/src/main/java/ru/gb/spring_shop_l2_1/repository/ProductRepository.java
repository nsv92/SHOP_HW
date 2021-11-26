package ru.gb.spring_shop_l2_1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.spring_shop_l2_1.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
