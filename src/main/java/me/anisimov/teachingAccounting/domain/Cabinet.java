package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cabinet")
@SequenceGenerator(name = "cabinet_seq_gen", sequenceName = "cabinet_seq", allocationSize = 1)
public class Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cabinet_seq")
    private Long id;

    @Column(name = "cabinet_name")
    private String cabinetName;

    @ManyToOne(targetEntity = CabinetType.class)
    @JoinColumn(name = "cabinet_type_id", nullable = false)
    private CabinetType cabinets;
}
