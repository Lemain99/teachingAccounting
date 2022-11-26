package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "academic_methods_activity_type")
@SequenceGenerator(name = "academic_methods_activity_type_seq_gen", sequenceName = "academic_methods_activity_type_seq", allocationSize = 1)
public class AcademicMethodsActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_methods_activity_type_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
