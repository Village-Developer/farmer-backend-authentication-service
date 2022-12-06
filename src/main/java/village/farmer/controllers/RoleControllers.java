package village.farmer.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleControllers {

    @PostMapping("/edit")
    @ResponseBody
    public void edit (@RequestHeader("Authorization") String token) {

    }
}
