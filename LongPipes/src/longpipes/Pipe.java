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
    private double outerDiameter;
    private double innerDiameter;
    private int grade;
    private String[] colours;
    private Boolean innerInsulation;
    private Boolean outerReinforcement;
    private Boolean chemicalResistance;
    private int pipeQuantity;
    

    public Pipe(double inputLength, double inputOuterDiameter, int inputGrade, String[] inputColours, Boolean inputInnerInsulation, Boolean inputOuterReinforcement, Boolean inputChemicalResistance, int inputPipeQuantity) {
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
    
    public double getLength() {
        return length;
    }
    
    public double getOuterDiameter() {
        return outerDiameter;
    }
    
    public double getInnerDiameter() {
        return innerDiameter;
    }
    
    public int getGrade() {
        return grade;
    }
    
    public String[] getColours() {
        return colours;
    }
    
    public Boolean getInnerInsulation() {
        return innerInsulation;
    }
    
    public Boolean getOuterReinforcement() {
        return innerInsulation;
    }
    
    public Boolean getChemicalResistance() {
        return chemicalResistance;
    }
    
    public int getPipeQuantity() {
        return pipeQuantity;
    }
    
    public double calculateCost() {
        //placeholder
        //check colours
        //check insulation
        //check reinforcement
        //check reistance
        //convert length to inches for plastic volume calculation
        return length * outerDiameter;
    }
   
    public void printDetails() {
        System.out.println("----------------------------------");         
        System.out.println("Length: " + length);
        System.out.println("Diameter: " + outerDiameter);
        System.out.println("----------------------------------"); 
    }
}
