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
public class TypeFivePipe extends TypeFourPipe{
    private final Boolean outerReinforcement;
    
    public TypeFivePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, true, pipeChemicalResistance, pipeQuantity);
        outerReinforcement = true;
    }
    
    /**
     * @return String containing all the pipe details
     */
    @Override
    public int getPipeType() { 
        return 5;
    }
    
    /**
     * @return The pipe's outer reinforcement
     */
    public Boolean getOuterReinforcement() {
        return outerReinforcement;
    }
    
    /**
     * @return The outer reinforcement cost
     */
    public double getOuterReinforcementCost() {
        return 0.17;
    }
    
    /**
     * @return The percentage extra costs based on the pipe additional costs
     */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;

        percentageExtra += getTwoColourCost();
        
        percentageExtra += getInnerInsulationCost();
        
        percentageExtra += getOuterReinforcementCost();
        
        if(getChemicalResistance()) {
            percentageExtra += getChemicalResistanceCost(); 
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
