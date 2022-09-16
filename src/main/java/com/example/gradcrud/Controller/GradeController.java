package com.example.gradcrud.Controller;

import com.example.gradcrud.Models.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String gradeForm(Model model,@RequestParam(required = false) String id) {
        Grade grade;
        if(getGradeIndex(id)==-1000){
            grade = new Grade();
        }else {
            grade = studentGrades.get(getGradeIndex(id));
        }

        model.addAttribute("grade", grade);
        return "gradeForm";
    }
    //endregion

    //region Name:upsertGrade,  METHOD:POST Description: add or update grades Routes:/handlesubmit
    @PostMapping(value = "/handlesubmit")
    public String upsertGrade(Grade grade) {
        var index = getGradeIndex(grade.getId());
        if(index==-1000){
            studentGrades.add(grade);
        }else {
            studentGrades.set(index, grade);
        }
        return "redirect:/";
    }
    //endregion

    private Integer getGradeIndex(String id){
        for (int i =0; i<studentGrades.size();i++){
            if(studentGrades.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1000;
    }
}
