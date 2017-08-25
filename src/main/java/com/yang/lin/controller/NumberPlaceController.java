package com.yang.lin.controller;

import com.yang.lin.numberplace.Sudoku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NumberPlaceController {
    private static final Random r = new Random();
    private List<Sudoku> initSudukos ;
    public NumberPlaceController(){
        initSudukos = new ArrayList<Sudoku>();
        for(int i=0;i<100;i++){
            Sudoku s = new Sudoku();
            initSudukos.add(s);
        }
    }


    @RequestMapping("/mp")
    public String toNumberPlace(Model model){
        Sudoku sudoku = initSudukos.get(r.nextInt(100));
        int[][] data = sudoku.getNext();
        data = Sudoku.initSudokuGame(data);
        model.addAttribute("data",data);
        return "NumberPlace";
    }
}
