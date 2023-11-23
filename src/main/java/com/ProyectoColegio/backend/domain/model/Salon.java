package com.ProyectoColegio.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "salon")
@Table(name = "salon")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
