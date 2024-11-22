package SpringBootProject.Student;

import SpringBootProject.Student.service.StudentEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/_student")
public class StudentControllerV2 {

    private final StudentEntryService studentEntryService;

    public StudentControllerV2(StudentEntryService studentEntryService) {
        this.studentEntryService = studentEntryService;
    }

    @PostMapping("/create-entry")
    public boolean createStudentEntry(@RequestBody StudentPOJO student) {
        studentEntryService.saveStudentEntry(student);
        return true;
    }

    @GetMapping("/get-entry/{myId}")
    public Optional<StudentPOJO> getStudentEntryById(@PathVariable int myId) {
        return studentEntryService.getStudentEntryById(myId);
    }

    @PutMapping("/update-entry/{myId}")
    public boolean updateStudentEntry(@PathVariable int myId, @RequestBody StudentPOJO student) {
        return studentEntryService.updateStudentEntry(myId, student);
    }

    @DeleteMapping("/delete-entry/{myId}")
    public boolean deleteStudentEntry(@PathVariable int myId) {
        return studentEntryService.deleteStudentEntry(myId);
    }


}
