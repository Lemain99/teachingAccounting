package me.anisimov.teachingAccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anisimov.teachingAccounting.domain.Enums.ActivityType;
import me.anisimov.teachingAccounting.domain.Enums.EventLevel;
import me.anisimov.teachingAccounting.domain.Enums.WorkVector;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducateDto {

    private Long id;
    private LocalDate date;
    private String result;
    private String eventType;
    private String eventName;
    private String studentInformation;
    private EventLevel eventLevel;
    private ActivityType activityType;
    private WorkVector workVector;
    private Long userId;
}
