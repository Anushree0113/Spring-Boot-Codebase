package SpringBootProject.Student;

import SpringBootProject.Student.service.StudentEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StudentPOJO> createStudentEntry(@RequestBody StudentPOJO student) {
        try {
            studentEntryService.saveStudentEntry(student);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-entry/{myId}")
    public ResponseEntity<StudentPOJO> getStudentEntryById(@PathVariable int myId) {
        Optional<StudentPOJO> studentEntryById = studentEntryService.getStudentEntryById(myId);
        if (studentEntryById.isPresent()) {
            return new ResponseEntity<>(studentEntryById.get(), HttpStatus.OK);
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
