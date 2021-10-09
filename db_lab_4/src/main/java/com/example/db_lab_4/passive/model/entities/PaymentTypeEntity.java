package com.example.db_lab_4.passive.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "payment_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString

public class PaymentTypeEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column (name = "type", length = 15)
    private String type;
    
}
