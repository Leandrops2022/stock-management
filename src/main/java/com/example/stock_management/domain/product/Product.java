package com.example.stock_management.domain.product;

import com.example.stock_management.domain.bin.Bin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "Product")
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private Bin bin;

    @Column(unique = true)
    private String sku;

    public Product(RegisterProductDTO registerProductDTO) {
        this.name = registerProductDTO.name();
        this.price = registerProductDTO.price();
        this.sku = registerProductDTO.sku();
    }
}
