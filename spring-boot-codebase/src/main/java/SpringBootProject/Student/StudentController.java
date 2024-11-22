package SpringBootProject.Student;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final Map<Integer, StudentPOJO> studentEntries = new HashMap<>();

    @GetMapping("/get/details")
    public List<StudentPOJO> getStudentDetails() {
        return new ArrayList<>(studentEntries.values());
    }

    @PostMapping("/add/details")
    public boolean addStudentDetails(@RequestBody StudentPOJO student) {
        studentEntries.put(student.getId(), student);
        return true;
    }

    @DeleteMapping("/remove/details/{id}")
    public boolean removeStudentDetails(@PathVariable int id) {
        studentEntries.remove(id);
        return true;
    }

    @PutMapping("/update/details")
    public boolean updateStudentDetails(@RequestBody StudentPOJO student) {
        studentEntries.put(student.getId(), student);
        return true;
    }

}
