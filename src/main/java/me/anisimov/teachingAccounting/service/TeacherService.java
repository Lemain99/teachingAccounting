package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.dto.TeacherDto;
import me.anisimov.teachingAccounting.repository.DepartmentRepository;
import me.anisimov.teachingAccounting.repository.TeacherRepository;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper mapper;

    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setCategory(teacherDto.getCategory());
        teacher.setDepartment(departmentRepository.getReferenceById(teacherDto.getDepartmentId()));
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setMiddleName(teacherDto.getMiddleName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setPosition(teacherDto.getPosition());
        teacher.setEmploymentType(teacherDto.getEmploymentType());
        teacher.setCertificationDate(teacherDto.getCertificationDate());
        teacherRepository.save(teacher);
        return mapper.map(teacher, TeacherDto.class);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher getById(Long id) {
        return teacherRepository.getReferenceById(id);
    }

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }
}
