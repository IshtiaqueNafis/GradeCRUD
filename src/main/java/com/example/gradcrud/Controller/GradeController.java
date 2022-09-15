package com.example.gradcrud.Controller;

import com.example.gradcrud.Models.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {
    List<Grade> studentGrades = new ArrayList<>();

    //region METHOD:GET Routes:/ Description:show all grades on a table
    @GetMapping(value = "/")
    public String showGrades(Model model) {

        model.addAttribute("grades", studentGrades);
        return "showGrades";
    }
    //endregion

    //region  Name:gradeForm(Model model)   METHOD:GET  Description:Directs to Grade Form Routes:/gradeform
    @GetMapping(value = "/gradeform")
    public String gradeForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "gradeForm";
    }
    //endregion

    //region Name:upsertGrade,  METHOD:POST Description: add or update grades Routes:/handlesubmit
    @PostMapping(value = "/handlesubmit")
    public String upsertGrade(Grade grade) {
        studentGrades.add(grade);
        return "redirect:/";
    }
    //endregion
}
