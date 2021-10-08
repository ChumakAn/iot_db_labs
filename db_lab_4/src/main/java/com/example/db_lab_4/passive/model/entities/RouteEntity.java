package com.example.db_lab_4.passive.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "route")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class RouteEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "date", length = 8)
    private String date;
    @Column(name = "guide_id")
    private Integer guideId;
    @Column(name = "name", length = 45)
    private String name;
}
