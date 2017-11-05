/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

/**
 *
 * @author hearn
 */
public class Pipe {
    private double length;
    private double diameter;

    public Pipe(double inputLength, double inputDiameter) {
        length = inputLength;
        diameter = inputDiameter;
    }
    
    public double getLength() {
        return length;
    }
    
    public double getDiameter() {
        return diameter;
    }
}
