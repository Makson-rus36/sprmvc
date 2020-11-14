package com.example;

import com.example.DBHelper.Helper;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String regForm(Model model) {
        model.addAttribute("registration", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String regSubmit(@ModelAttribute User user, Model model) throws SQLException, ClassNotFoundException {
        Helper helper1= new Helper();
        if(helper1.checkExistUser(user.getLogin(), user.getPassword()))
        {
            return "RetryReg";
        }else{

        helper1.insert(user.getLogin(),user.getPassword(),user.getName(),user.getLastname());
        return "GoToEnter";
        }

    }


}