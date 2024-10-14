package com.example.stock_management.domain.bin;

import com.example.stock_management.domain.shelf.Shelf;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name="Bin")
@Table(name = "bins")
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String binCode;

    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

}
