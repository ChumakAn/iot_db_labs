package com.example.db_lab_4.passive.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "guide")
@ToString
public class GuideEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 30)
    private String name;
    @Column(name = "surname", length = 30)
    private String surname;
    @Column(name = "telephone_number", length = 12)
    private String telephoneNumber;

}
