package com.example;
import com.example.DBHelper.Helper;
import com.example.model.UserDataEnter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("login", new UserDataEnter());
        return "login";
    }
    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute UserDataEnter userDataEnter, Model model) throws SQLException, ClassNotFoundException {

        Helper helper= new Helper();
        if(helper.checkExistUser(userDataEnter.getLogin(), userDataEnter.getPassword()))
        {
            userDataEnter.setName(helper.name);
            userDataEnter.setLastname(helper.lastname);
            model.addAttribute("result", userDataEnter);
            return "result";
        }
        else{
            return "result1";
        }
    }


}
