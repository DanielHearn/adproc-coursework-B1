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
public class TypeTwoPipe extends Pipe{
    
    public TypeTwoPipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColors, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColors, false, false, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
    * @return The total cost of the pipe based on volume, additional costs and grade
    */
    @Override
    public double calculateCost() {
        double percentageExtra = getPercentageExtraCosts();
        
        double pipeVolume = calculatePipeVolume();
        
        double materialCost = pipeVolume * 0.6;

        System.out.println("Extra: " + percentageExtra);
        double pipeCost = materialCost + (materialCost * percentageExtra);
        System.out.println("Pipe Cost: " + pipeCost);
        double orderCost = pipeCost * getPipeQuantity();
        return orderCost;
    }
}
