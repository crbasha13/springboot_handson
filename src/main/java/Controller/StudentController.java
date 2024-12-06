package Controller;

import Model.Student;
import Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    public StudentService stds;

    //To fetch all the students
    @GetMapping("/get-students")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(stds.getStudents());
    }

    //To fetch students with id
    @GetMapping("/{id}")
    public Object getById(@PathVariable int id){
        Optional<Student> s1 = stds.getById(id);
        if(s1.isPresent())
            return ResponseEntity.ok(s1);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
    }

    //To fetch students who are having marks more than 40 in all subjects
    @GetMapping("/rank-students")
    public ResponseEntity<List<Student>> rankStudents(){
        return ResponseEntity.ok(stds.rankStudents());
    }

    //To add new students
    @PostMapping("/add-students")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> addstd){
       return ResponseEntity.ok(stds.addStudents(addstd));
    }

    //To add 5 marks to the students who are having their total marks more than 300
    @PutMapping("/add-marks/{id}")
    public ResponseEntity<Object> updateMarks(@PathVariable int id){
        Optional<Student> s2 = stds.getById(id);
        if(s2.isPresent()) {
            try {
                Student updatedStudent = stds.updateMarks(id);
                return ResponseEntity.ok(updatedStudent);
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
    }

    //To delete students by their id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Optional<Student> s1 = stds.getById(id);
        if(s1.isPresent()) {
            stds.deletestudent(id);
            return ResponseEntity.ok("Deleted successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
    }


}
