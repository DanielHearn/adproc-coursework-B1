/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

/**
 *
 * @author up801685
 */
public class TypeOnePipe extends Pipe{
    
    public TypeOnePipe(double inputLength, double inputDiameter, int pipeGrade, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, 0, false, false, pipeChemicalResistance, pipeQuantity);
    }
    
}
