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
public class TypeFivePipe extends TypeThreePipe{
    
    public TypeFivePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColors, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColors, true, true, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
    * @return String containing all the pipe details
    */
    @Override
    public int getPipeType() { 
        return 5;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
    */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;

        // Add two pipe colour cost
        percentageExtra += 0.16;
        
        // Add inner insulation cost
        percentageExtra += 0.13;
        
        // Add outer reinforcement cost
        percentageExtra += 0.17;
        
        if(this.getChemicalResistance()) {
            percentageExtra += 0.14;   
        }
        
        return percentageExtra;
    } 
}
