/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpipes;

/**
 * Pipe class that is a super class of the pipe types with all pipe specifications
 * @author hearn
 */
public class Pipe {
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
    * @return The pipe length
    */
    public double getLength() {
        return length;
    }
    
    /**
    * @return The pipe outer diameter
    */
    public double getOuterDiameter() {
        return outerDiameter;
    }
    
    /**
    * @return The pipe inner diameter
    */
    public double getInnerDiameter() {
        return innerDiameter;
    }
    
    /**
    * @return The pipe grade
    */
    public int getGrade() {
        return grade;
    }
    
    /**
    * @return The pipe colours 
    */
    public int getColours() {
        return colours;
    }
    
    /**
    * @return The inner insulation
    */
    public Boolean getInnerInsulation() {
        return innerInsulation;
    }
    
    /**
    * @return The outer reinforcement
    */
    public Boolean getOuterReinforcement() {
        return outerReinforcement;
    }
    
    /**
    * @return The chemical resistance
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
    * @return The percentage extra costs based on the pipe additional costs
    */
    public double getPercentageExtraCosts() {
        double percentageExtra = 0;

        if(colours == 1)  {
            percentageExtra += 0.12;
        } else if(colours == 2) {
            percentageExtra += 0.16;
        }
        
        if(innerInsulation) {
            percentageExtra += 0.13;
        }
        
        if(outerReinforcement) {
            percentageExtra += 0.17;
        }
        
        if(chemicalResistance) {
            percentageExtra += 0.14;   
        }
        
        return percentageExtra;
    } 
    
    /**
    * @return The pipe plastic material volume
    */
    public double calculatePipeVolume() {
        double lengthInches = length * 39.37;
   
        double outerRadius = outerDiameter / 2;
        double innerRadius = innerDiameter / 2;
       
        double pipeVolume = Math.PI * lengthInches * (Math.pow(outerRadius,2) - Math.pow(innerRadius, 2) );
        System.out.println("VOLUME " + pipeVolume);
        return pipeVolume;
    }
    
    /**
    * @return The total cost of the pipe based on volume, additional costs and grade
    */
    public double calculateCost() {
        //overwrite within other pipes
        //seperate into functions (keep other functions here, e.g additional costs and matrial costs)
        double percentageExtra = getPercentageExtraCosts();
        
        double pipeVolume = calculatePipeVolume();
        //based on grade calculate cost per inch3
        double materialCost = 0;
        
        switch (grade) {
            case 1:
                materialCost = pipeVolume * 0.4;
                break;
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
                materialCost = pipeVolume;
                break;
        }
        System.out.println("Extra: " + percentageExtra);
        double pipeCost = materialCost + (materialCost * percentageExtra);
        System.out.println("Pipe Cost: " + pipeCost);
        double orderCost = pipeCost * pipeQuantity;
        return orderCost;
    }
   
    /**
    * @return String containing all the pipe details
    */
    public String getDetails() {
        String classNameString = this.getClass().getSimpleName();
        String className = "Type ";
        switch (classNameString) {
            case "TypeOnePipe":  
                className += "1";
                break;
            case "TypeTwoPipe":  
                className += "2";
                break;
            case "TypeThreePipe":  
                className += "3";
                break;
            case "TypeFourPipe":  
                className += "4";
                break;
            case "TypeFivePipe":  
                className += "5";
                break;
            default:  
                className += "1";
                break;
        }        
        
        String pipeDetailString = className + " - [Length: " + length + ", Diameter: " + outerDiameter + ", Colours: " + colours + ", Quantity: " + pipeQuantity + "]";
        return pipeDetailString;
    }
}
