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
    
    public double getPercentageExtraCosts() {
        int percentageExtra = 0;
        
        if(colours.length == 1)  {
            percentageExtra += 12;
        } else if(colours.length == 2) {
            percentageExtra += 16;
        }
        
        if(innerInsulation) {
            percentageExtra += 13;
        }
        
        if(outerReinforcement) {
            percentageExtra = 17;
        }
        
        if(chemicalResistance) {
            percentageExtra = 14;   
        }
        
        return percentageExtra;
    } 
    
    public double calculatePipeVolume() {
        double lengthInches = length * 39.37;
        double fullPipeVolume = Math.PI * (outerDiameter*2) * lengthInches;
        double interiorPipeVolume = Math.PI * (innerDiameter*2) * lengthInches;
        
        double pipeVolume = fullPipeVolume - interiorPipeVolume;
        return pipeVolume;
    }
    
    public double calculateCost() {
        //overwrite within other pipes
        //seperate into functions (keep other functions here, e.g additional costs and matrial costs)
        double percentageExtra = getPercentageExtraCosts();
        
        double pipeVolume = calculatePipeVolume();
        //based on grade calculate cost per inch3
        double materialCost = 0;
        
        switch(grade) {
            case 1:
                materialCost = pipeVolume * 0.4;
            case 2:
                materialCost = pipeVolume * 0.6;
            case 3:
                materialCost = pipeVolume * 0.75;
            case 4:
                materialCost = pipeVolume * 0.8;
            case 5:
                materialCost = pipeVolume * 0.95;
        }
        
        double pipeCost = materialCost * percentageExtra;
        return pipeCost * pipeQuantity;
    }
   
    public void printDetails() {
        System.out.println("----------------------------------");         
        System.out.println("Length: " + length);
        System.out.println("Diameter: " + outerDiameter);
        System.out.println("----------------------------------"); 
    }
}
