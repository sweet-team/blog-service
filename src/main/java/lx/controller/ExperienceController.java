package lx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExperienceController {

   /* @GetMapping("/test")
    public ResponseEntity<List<Test>> test(){
        ArrayList<Test> tests = new ArrayList<>();
        tests.add(new Test("1",24,"name1"));
        tests.add(new Test("2",12,"name2"));
        tests.add(new Test("3",11,"name3"));
        tests.add(new Test("4",13,"name4"));
        tests.add(new Test("5",14,"name5"));
        tests.add(new Test("6",15,"name6"));
        return ResponseEntity.ok(tests);
    }*/
}
