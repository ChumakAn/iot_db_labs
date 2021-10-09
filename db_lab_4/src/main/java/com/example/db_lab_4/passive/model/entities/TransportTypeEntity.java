package com.example.db_lab_4.passive.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "transport_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TransportTypeEntity {
    @Id
    @Column(name = "id")
    private Integer id ;
    @Column(name = "name", length = 45)
    private String name;
}
