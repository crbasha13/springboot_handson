package Repository;

import Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findByrollNo(int rollNo);
    @Query("select s from Student s where " +
            "s.english>40 and s.hindi>40 and s.maths>40 and s.science>40 and s.social>40 order by s.name")
    List<Student> rankStudents();

}
