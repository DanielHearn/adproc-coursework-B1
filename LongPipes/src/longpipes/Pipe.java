/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

/**
 * Pipe class that is a super class of the pipe types with all pipe specifications
 * @author dan 801685
 */
public abstract class Pipe {
    private final double length;
    private final double outerDiameter;
    private final double innerDiameter;
    private final int grade;
    private final int colours;
    private final Boolean innerInsulation;
    private final Boolean outerReinforcement;
    private final Boolean chemicalResistance;
    private final int pipeQuantity;
   
    /**
    * Construct a new pipe with all pipe specifications
     * @param inputLength
     * @param inputOuterDiameter
     * @param inputGrade
     * @param inputColours
     * @param inputInnerInsulation
     * @param inputOuterReinforcement
     * @param inputChemicalResistance
     * @param inputPipeQuantity
    */
    public Pipe(double inputLength, double inputOuterDiameter, int inputGrade, int inputColours, Boolean inputInnerInsulation, Boolean inputOuterReinforcement, Boolean inputChemicalResistance, int inputPipeQuantity) {
        length = inputLength;
        outerDiameter = inputOuterDiameter;
        innerDiameter = outerDiameter*0.9;
        grade = inputGrade;
        colours = inputColours;
        innerInsulation = inputInnerInsulation;
        outerReinforcement = inputOuterReinforcement;
        chemicalResistance = inputChemicalResistance;
        pipeQuantity = inputPipeQuantity;
    }
    
    /**
    * @return The pipe's length
    */
    public double getLength() {
        return length;
    }
    
    /**
    * @return The pipe's outer diameter
    */
    public double getOuterDiameter() {
        return outerDiameter;
    }
    
    /**
    * @return The pipe's inner diameter
    */
    public double getInnerDiameter() {
        return innerDiameter;
    }
    
    /**
    * @return The pipe's grade
    */
    public int getGrade() {
        return grade;
    }
    
    /**
    * @return The pipe's pipe colours 
    */
    public int getColours() {
        return colours;
    }
    
    /**
    * @return The pipe's inner insulation
    */
    public Boolean getInnerInsulation() {
        return innerInsulation;
    }
    
    /**
    * @return The pipe's outer reinforcement
    */
    public Boolean getOuterReinforcement() {
        return outerReinforcement;
    }
    
    /**
    * @return The pipe's chemical resistance
    */
    public Boolean getChemicalResistance() {
        return chemicalResistance;
    }
    
    /**
    * @return The quantity of the pipes ordered
    */
    public int getPipeQuantity() {
        return pipeQuantity;
    }
    
    /**
    * @return The additional cost for one colour
    */
    public double getOneColourCost() {
        return 0.12;
    }
    
    /**
    * @return The additional cost for one colour
    */
    public double getTwoColourCost() {
        return 0.16;
    }
    
    /**
    * @return The inner insulation cost
    */
    public double getInnerInsulationCost() {
        return 0.13;
    }
    
    /**
    * @return The outer reinforcement cost
    */
    public double getOuterReinforcementCost() {
        return 0.17;
    }
  
    /**
    * @return The chemical resistance cost
    */
    public double getChemicalResistanceCost() {
        return 0.14;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
    */
    public double calculatePercentageExtra() {
        return 0;
    } 
    
    /**
    * @return The pipe plastic material volume
    */
    public double calculatePipeVolume() {
        double lengthInches = length * 39.37;
   
        double outerRadius = outerDiameter / 2;
        double innerRadius = innerDiameter / 2;
       
        double pipeVolume = Math.PI * lengthInches * (Math.pow(outerRadius,2) - Math.pow(innerRadius, 2) );
        return pipeVolume;
    }
    
    /**
    * @return The total cost of the pipe based on the individual cost and quantity of pipes ordered
    */
    public double calculateTotalCost() {
        double individualPipeCost = calculateIndividualCost();
        double pipeOrderCost = individualPipeCost * pipeQuantity;
        return pipeOrderCost;
    }
   
    /**
    * @return The total cost of an individual pipe within the order
    */
    public double calculateIndividualCost() {
        double percentageExtra = calculatePercentageExtra();
        double pipeVolume = calculatePipeVolume();
        double materialCost = calculateMaterialCost(pipeVolume, grade);
        double pipeCost = materialCost + calculateExtraFeatureCost(materialCost, percentageExtra); 
        return pipeCost;
    }
    
    /**
     * @param materialCost The cost for the materials of an individual pipe
     * @param percentageExtra The percentage extra based on the pipe's additional features
    * @return The cost of the extra features for an individual pipe
    */
    public double calculateExtraFeatureCost(double materialCost, double percentageExtra) {
        return materialCost * percentageExtra;
    }
    
    /**
     * @param pipeVolume The volume of the pipe
     * @param pipeGrade The grade of the pipe
    * @return The cost for the material of an individual pipe
    */
    public double calculateMaterialCost(double pipeVolume, int pipeGrade) {
        return 0;
    }
    
    /**
    * @return String containing all the pipe details, Override by pipe subclasses
    */
    public int getPipeType() { 
        return 0;
    }
    
    /**
    * @return String containing all the pipe details
    */
    public String getDetails() {
        String pipeDetailString = "Type " + getPipeType() + " Pipe - [Length: " + length + ", Diameter: " + outerDiameter + 
            ", Colours: " + colours + ", Quantity: " + pipeQuantity + "]" + " = " + String.format("£%.2f", calculateTotalCost());
        return pipeDetailString;
    }
}
