package in.piyush.repository;

import in.piyush.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {

    private static Map<Long,Student> mp ;


    public StudentRepo() {
        this.mp = new HashMap<>();
    }

    public Student save(Student studentReq){

        mp.put(studentReq.getId(),studentReq);

        return studentReq;
    }

    public  Student findById(Student studentReq){
        return mp.get(studentReq.getId());
    }

    public List<Student> findall(){
        return new ArrayList<>(mp.values());
    }


}
