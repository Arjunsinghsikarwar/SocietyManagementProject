package SecurityManagementBackend.Backend.Controller.ComplaintController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaint")
public class ComplaintControllerImplementation {


    @PostMapping("/createNewComplaint")
    public void createNewComplaint(){

    }

    @GetMapping("getAllComplaints")
    public void getAllComplaints(){

    }


}
