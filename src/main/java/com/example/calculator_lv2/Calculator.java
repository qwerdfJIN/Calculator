package com.example.calculator_lv2;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    private List<Integer> results = new ArrayList<>();

    public int calculate(int a, int b, char operator) {
        int result = 0;

        if (operator == '+') {
            result = a + b;
        } else if (operator == '-') {
            result = a - b;
        } else if (operator == '*') {
            result = a * b;
        } else if (operator == '/') {
            if (b == 0) {
                return -1;
            }
            result = a / b;
        }
        results.add(result);
        return result;
    }

    public List<Integer> getResults() {
        return results;
    }
    public void setResults(List<Integer> results){
        this.results = results;
    }
    public void removeResults(){
        if(!results.isEmpty()){
            results.remove(0);
        }
    }
}