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
public class TypeThreePipe extends Pipe{
    
    public TypeThreePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColors, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColors, false, false, pipeChemicalResistance, pipeQuantity);
    }
    
    // Constructor for type four and five pipes
    public TypeThreePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColors, boolean innerInsulation, boolean outerReinforcement, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColors, innerInsulation, outerReinforcement, pipeChemicalResistance, pipeQuantity);
    }

    /**
    * @return String containing all the pipe details
    */
    @Override
    public int getPipeType() { 
        return 3;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
    */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;
        
        // Add two pipe colour cost
        percentageExtra += 0.16;
        
        if(this.getChemicalResistance()) {
            percentageExtra += 0.14;   
        }
        
        return percentageExtra;
    } 
}
