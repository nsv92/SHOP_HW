package ru.gb.spring_shop_l2_1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.spring_shop_l2_1.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
