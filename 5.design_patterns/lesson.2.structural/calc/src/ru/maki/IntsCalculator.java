package ru.maki;

public class IntsCalculator implements Ints {

    protected final Calculator target;

    public IntsCalculator() {
        this.target = new Calculator();
    }

    /**
     * операция сложения
     *
     * @param arg0
     * @param arg1
     * @return
     */
    @Override
    public int sum(int arg0, int arg1) {
        return (int) target.newFormula().addOperand(arg0).addOperand(arg1).calculate(Calculator.Operation.SUM).result();
    }

    /**
     * операция умножения
     *
     * @param arg0
     * @param arg1
     * @return
     */
    @Override
    public int mult(int arg0, int arg1) {
        return (int) target.newFormula().addOperand(arg0).addOperand(arg1).calculate(Calculator.Operation.MULT).result();
    }

    /**
     * операция возведения в степень
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int pow(int a, int b) {
        return (int) target.newFormula().addOperand(a).addOperand(b).calculate(Calculator.Operation.POW).result();
    }
}
