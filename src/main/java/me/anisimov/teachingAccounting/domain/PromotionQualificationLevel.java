package me.anisimov.teachingAccounting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="promotion_qualification_level")
@SequenceGenerator(name = "promotion_qualification_level_seq_gen", sequenceName = "promotion_qualification_level_seq", allocationSize = 1)
public class PromotionQualificationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_qualification_level_seq")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "place")
    private String place;

    @Column(name = "topic")
    private String topic;

    @Column(name = "document_or_result")
    private String documentOrResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "promotion_form")
    private PromotionForm promotionForm;


}