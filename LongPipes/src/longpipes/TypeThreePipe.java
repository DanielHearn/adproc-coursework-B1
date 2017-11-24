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
    
    public TypeThreePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, false, false, pipeChemicalResistance, pipeQuantity);
    }
    
    // Constructor for type four and five pipes
    public TypeThreePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean innerInsulation, boolean outerReinforcement, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, innerInsulation, outerReinforcement, pipeChemicalResistance, pipeQuantity);
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
        
        percentageExtra += this.getTwoColourCost();
        
        if(this.getChemicalResistance()) {
            percentageExtra += this.getChemicalResistanceCost();
        }
        
        return percentageExtra;
    } 
    
    /**
     * @param pipeVolume The volume of the pipe
     * @param pipeGrade The grade of the pipe
    * @return The cost for the material of an individual pipe
    */
    @Override
    public double calculateMaterialCost(double pipeVolume, int pipeGrade) {
        double materialCost = 0;
        
        switch (pipeGrade) {
            case 2:
                materialCost = pipeVolume * 0.6;
                break;
            case 3:
                materialCost = pipeVolume * 0.75;
                break;
            case 4:
                materialCost = pipeVolume * 0.8;
                break;
            case 5:
                materialCost = pipeVolume * 0.95;
                break;
            default:
                materialCost = pipeVolume * 0.6;
                break;
        }
        return materialCost;
    }
}
