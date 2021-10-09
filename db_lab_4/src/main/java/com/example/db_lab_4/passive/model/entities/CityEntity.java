package com.example.db_lab_4.passive.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class CityEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column (name = "hotel_id")
    private Integer hotelId;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "country_id")
    private Integer countryId;

}
