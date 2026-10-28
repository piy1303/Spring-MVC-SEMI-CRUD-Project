package in.piyush.Service;

import in.piyush.entity.Student;
import in.piyush.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    private StudentRepo studentRepo;


    public studentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student studentReq){

        return studentRepo.save(studentReq);

    }


    public Student findOne(Student studentReq){

        return studentRepo.findById(studentReq);

    }


    public List<Student> getAll(){

        return studentRepo.findall();

    }


}
