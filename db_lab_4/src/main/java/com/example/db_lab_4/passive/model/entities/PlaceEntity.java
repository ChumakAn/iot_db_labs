package com.example.db_lab_4.passive.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class PlaceEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column (name = "city_id")
    private Integer cityId;
    @Column(name = "name", length = 45)
    private String name;

}
