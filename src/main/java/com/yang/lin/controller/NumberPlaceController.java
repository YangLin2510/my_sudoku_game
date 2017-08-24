package com.yang.lin.controller;

import com.yang.lin.numberplace.Sudoku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NumberPlaceController {
    @Autowired
    private Sudoku sudoku ;
    @RequestMapping("/mp")
    public String toNumberPlace(){
        return "NumberPlace";
    }


    @ResponseBody
    @RequestMapping("/sudoku")
    public int[][] getSudoku(){
           return sudoku.getNext();
    }
}
