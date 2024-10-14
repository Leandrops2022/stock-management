package com.example.stock_management.domain.shelf;

import com.example.stock_management.domain.aisle.Aisle;
import com.example.stock_management.domain.bin.Bin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="Shelf")
@Table(name="shelves")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shelfCode;

    @ManyToOne
    @JoinColumn(name = "aisle_id")
    private Aisle aisle;

    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL)
    private List<Bin> bins;

}