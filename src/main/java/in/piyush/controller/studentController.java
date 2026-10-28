package in.piyush.controller;

import in.piyush.Service.studentService;
import in.piyush.entity.Student;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {

    private studentService studentService;


    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStd(@RequestBody Student studentReq){
        Student stRes = studentService.createStudent(studentReq);

        return ResponseEntity.ok(stRes);
    }


    @GetMapping("getOne/{id}")
    public ResponseEntity<Student> getOne(@RequestParam("id") Long id , @RequestBody Student studentReq){

        Student stone = studentService.findOne(studentReq);

        if (stone == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stone);

    }

    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getA(@RequestBody Student studentReq){

        List<Student> stall = studentService.getAll();

        return ResponseEntity.ok(stall);

    }




}
