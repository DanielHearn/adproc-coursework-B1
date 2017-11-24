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
public class TypeFourPipe extends TypeThreePipe{
    
    public TypeFourPipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, true, false, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
    * @return String containing all the pipe details
    */
    @Override
    public int getPipeType() { 
        return 4;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
    */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;

        percentageExtra += this.getTwoColourCost();
        
        percentageExtra += this.getInnerInsulationCost();
        
        if(this.getChemicalResistance()) {
            percentageExtra += this.getChemicalResistanceCost();
        }
        
        return percentageExtra;
    } 
}
