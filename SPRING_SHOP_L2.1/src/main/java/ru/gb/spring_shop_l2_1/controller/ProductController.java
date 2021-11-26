package ru.gb.spring_shop_l2_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.spring_shop_l2_1.repository.ProductRepository;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String Products(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }


}
