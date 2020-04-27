package com.hifnawy.math;

public class MathOperations {
    private int firstNumber;
    private int secondNumber;

    public MathOperations() {
    }

    public MathOperations(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int add() {
        return firstNumber + secondNumber;
    }

    public int subFS() {
        return firstNumber - secondNumber;
    }

    public int subSF() {
        return secondNumber - firstNumber;
    }
}
