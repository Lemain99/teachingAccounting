package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="academic_production")
@SequenceGenerator(name = "academic_production_seq_gen", sequenceName = "academic_production_seq", allocationSize = 1)
public class AcademicProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_production_seq")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;

    // ama - Academic Method Activity
    @Column(name = "ama_form")
    private String amaForm;

    @Enumerated(EnumType.STRING)
    @Column(name = "cabinet_type")
    private CabinetType cabinetType;

    @Column(name = "cabinet_name")
    private  String cabinetName;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type")
    private ActivityType activityType;

    @OneToOne(targetEntity = Specialization.class)
    @JoinColumn(name="specialization_id", nullable=false)
    private Specialization specialization;

}