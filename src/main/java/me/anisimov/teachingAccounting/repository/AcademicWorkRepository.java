package me.anisimov.teachingAccounting.repository;

import me.anisimov.teachingAccounting.domain.AcademicWork;
import me.anisimov.teachingAccounting.domain.Teacher;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicWorkRepository extends JpaRepository<AcademicWork,Long> {

    List<AcademicWork> findAllByUser(User user);

    Page<AcademicWork> getAllByUser(User user, Pageable pageable);
}
