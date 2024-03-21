package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString

public class Product
{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//  Can include above line if we want to autogenerate the
//  product id's.
    public long id; // This is the primary key
    public String name; // This is a regular attribute
    public int price; // This is a regular attribute
    @JsonIgnore
    @ManyToOne
    @JsonIgnoreProperties("products")
    public Seller seller;
}
