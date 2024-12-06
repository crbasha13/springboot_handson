package Service;

import Model.Student;
import Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    public StudentRepo std;
    public List<Student> getStudents(){
        return std.findAll();
    }

    public Optional<Student> getById(int id) {
        return std.findById(id);
    }

    public List<Student> rankStudents() {
        return std.rankStudents();
    }

    public List<Student> addStudents(List<Student> addstd) {
        return std.saveAll(addstd);
    }

    public Student updateMarks(int id){
            Student student = std.findByrollNo(id);
            if (student.isMarksUpdated()) {
            throw new RuntimeException("Marks already added");
            }
            if (student.getTotalMarks() > 300) {
                student.setEnglish(student.getEnglish() + 5);
                student.setMarksUpdated(true);
                return std.save(student);
            } else {
                throw new RuntimeException("Total marks must be more than 300");
            }
    }

    public void deletestudent(int id){
        std.deleteById(id);
    }


}
