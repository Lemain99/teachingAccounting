package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "academic_production_activity_form")
@SequenceGenerator(name = "academic_production_activity_form_seq_gen", sequenceName = "academic_production_activity_form_seq", allocationSize = 1)
public class AcademicProductionActivityForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_production_activity_form_seq")
    private Long id;

    @Column(name = "name")
    private String name;
}
