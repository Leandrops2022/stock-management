package com.example.stock_management.domain.aisle;

import com.example.stock_management.domain.section.Section;
import com.example.stock_management.domain.shelf.Shelf;
import jakarta.persistence.*;

import java.util.List;

public class Aisle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aisleCode;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "aisle", cascade = CascadeType.ALL)
    private List<Shelf> shelves;

}
