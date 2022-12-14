package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.AcademicMethods;
import me.anisimov.teachingAccounting.domain.User;
import me.anisimov.teachingAccounting.dto.AcademicMethodsDto;
import me.anisimov.teachingAccounting.repository.AcademicMethodsRepository;
import me.anisimov.teachingAccounting.util.SecurityUtils;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AcademicMethodsService {

    @Autowired
    private AcademicMethodsRepository academicMethodsRepository;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private AcademicDisciplineService academicDisciplineService;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public AcademicMethodsDto createAcademicMethods(AcademicMethodsDto academicMethodsDto) {

        Long userId = academicMethodsDto.getUserId();

        User user = (userId != null)
                ? userDetailsServiceImpl.getById(userId)
                : userDetailsServiceImpl.getCurrentUser();

        AcademicMethods academicMethods = new AcademicMethods();
        academicMethods.setUser(user);
        academicMethods.setId(academicMethodsDto.getId());
        academicMethods.setAcademicDiscipline(academicDisciplineService.getById(academicMethodsDto.getAcademicDisciplineId()));
        academicMethods.setAcademicMethodActivityForm(academicMethodsDto.getAcademicMethodActivityForm());
        academicMethods.setAcademicMethodActivityType(academicMethodsDto.getAcademicMethodActivityType());
        academicMethods.setSpecialization(specializationService.getById(academicMethodsDto.getSpecializationId()));
        academicMethods.setActivityType(academicMethodsDto.getActivityType());
        academicMethods.setDeadLine(academicMethodsDto.getDeadLine());
        academicMethods.setCompleteInfo(academicMethodsDto.getCompleteInfo());

        academicMethodsRepository.save(academicMethods);
        return mapper.map(academicMethods, AcademicMethodsDto.class);
    }

    public void deleteAcademicMethods(Long id) {
        academicMethodsRepository.deleteById(id);
    }

    public void updateAcademicMethods(AcademicMethods academicMethods) {
        academicMethodsRepository.save(academicMethods);
    }

    public AcademicMethods getById(Long id) {
        return academicMethodsRepository.getReferenceById(id);
    }

    public List<AcademicMethodsDto> getAll() {
        return academicMethodsRepository.findAll().stream()
                .map(entity ->  mapper.map(entity, AcademicMethodsDto.class))
                .collect(Collectors.toList());
    }

    public Page<AcademicMethodsDto> getCurrentAcademicMethods(PageRequest pageRequest) {
        User user = userDetailsServiceImpl.findByLogin(SecurityUtils.getCurrentUsername());
        Page<AcademicMethodsDto> allUsersInformation = academicMethodsRepository.getAllByUser(user,pageRequest).map(work -> {
            return mapper.map(work, AcademicMethodsDto.class);
        });
        return allUsersInformation;
    }
}

