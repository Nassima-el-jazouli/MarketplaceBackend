package org.sid.announcementService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class samirCon {

    @GetMapping("/cc")
    String get(){
        return "hello";
    }

}
