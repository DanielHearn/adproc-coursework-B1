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
public class TypeFourPipe extends Pipe{
    
    public TypeFourPipe(double inputLength, double inputDiameter, int pipeGrade, String[] pipeColors, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColors, true, false, pipeChemicalResistance, pipeQuantity);
    }
    
}
