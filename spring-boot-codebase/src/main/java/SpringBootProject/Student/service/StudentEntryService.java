package SpringBootProject.Student.service;

import SpringBootProject.Student.StudentPOJO;
import SpringBootProject.Student.repository.StudentEntryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class StudentEntryService {

    Logger Klogger = LoggerFactory.getLogger(StudentEntryService.class);

    private final StudentEntryRepo studentEntryRepo;

    public StudentEntryService(StudentEntryRepo studentEntryRepo) {
        this.studentEntryRepo = studentEntryRepo;
    }

    public void saveStudentEntry(StudentPOJO studentPOJO) {
        studentEntryRepo.save(studentPOJO);
        Klogger.info(studentPOJO.toString());
    }

    public Optional<StudentPOJO> getStudentEntryById(int id) {
        return studentEntryRepo.findById(id);
    }

    public boolean updateStudentEntry(int id, StudentPOJO newEntry) {
        StudentPOJO studentPOJO1 = studentEntryRepo.findById(id).orElse(null);
        if (studentPOJO1 != null) {
            studentPOJO1.setName(newEntry.getName() != null && !newEntry.getName().isEmpty() ? newEntry.getName() : studentPOJO1.getName());
        }
        studentEntryRepo.save(studentPOJO1);
        return true;
    }

    public boolean deleteStudentEntry(int id) {
        StudentPOJO studentPOJO = studentEntryRepo.findById(id).orElse(null);
        if (studentPOJO != null) {
            studentEntryRepo.delete(studentPOJO);
        }
        return true;
    }
}
