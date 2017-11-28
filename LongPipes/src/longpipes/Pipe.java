package longpipes;

/**
 * Pipe class that is the abstract super class of the pipe types
 * @author dan 801685
 */
public abstract class Pipe {
    private final double length;
    private final double outerDiameter;
    private final double innerDiameter;
    private final int grade;
    private final int colours;
    private final Boolean chemicalResistance;
    private final int pipeQuantity;
   
    /**
     * Construct a new pipe with the common pipe specifications used by all other pipe types
     * @param inputLength the double representing the length of this pipe
     * @param inputOuterDiameter the double representing the outer diameter of this pipe
     * @param inputGrade the integer representing the plastic grade of this pipe
     * @param inputColours the integer representing the number of colours being used in this pipe
     * @param inputChemicalResistance the boolean representing if this pipe has chemical resistance properties
     * @param inputPipeQuantity the integer representing the quantity of this pipe being ordered
     */
    public Pipe(double inputLength, double inputOuterDiameter, int inputGrade, int inputColours, Boolean inputChemicalResistance, int inputPipeQuantity) {
        length = inputLength;
        outerDiameter = inputOuterDiameter;
        innerDiameter = outerDiameter*0.9; //The inner diameter of this pipe is always 90% of the outer diameter
        grade = inputGrade;
        colours = inputColours;
        chemicalResistance = inputChemicalResistance;
        pipeQuantity = inputPipeQuantity;
    }
    
    /**
     * Gets the double representing the length of this pipe
     * @return the length of this pipe
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Gets the double representing the outer diameter of this pipe
     * @return the outer diameter of this pipe
     */
    public double getOuterDiameter() {
        return outerDiameter;
    }
    
    /**
     * Gets the double representing the inner diameter of this pipe
     * @return the inner diameter of this pipe
     */
    public double getInnerDiameter() {
        return innerDiameter;
    }
    
    /**
     * Gets the integer representing the number of colours being used in this pipe
     * @return the number of colours being used in this pipe
     */
    public int getColours() {
        return colours;
    }
    
    /**
     * Get the integer representing the plastic grade of this pipe
     * @return the plastic grade of this pipe
     */
    public int getGrade() {
        return grade;
    }
    
    /**
     * Gets the boolean representing the chemical resistance property of this pipe
     * @return the chemical resistance property of this pipe
     */
    public Boolean getChemicalResistance() {
        return chemicalResistance;
    }
    
    /**
     * Gets the integer representing the quantity of this pipe being ordered
     * @return the quantity of this pipe being ordered
     */
    public int getPipeQuantity() {
        return pipeQuantity;
    }
    
    /**
     * Gets the double representing the percentage extra cost of the chemical resistance property
     * @return the cost of the chemical resistance property
     */
    public double getChemicalResistanceCost() {
        return 0.14;
    }
    
    /**
     * Gets the double representing the plastic material volume of this pipe
     * @return the plastic material volume of this pipe
     */
    public double calculatePipeVolume() {
        double lengthInches = length * 39.37; //One metre is equal to 39.37 inches
   
        double outerRadius = outerDiameter / 2;
        double innerRadius = innerDiameter / 2;
       
        double pipeVolume = Math.PI * lengthInches * (Math.pow(outerRadius,2) - Math.pow(innerRadius, 2) );
        return pipeVolume;
    }
    
    /**
     * Gets the total cost of this pipe based on the individual cost and quantity of pipes ordered
     * @return the total cost of this pipe order
     */
    public double calculateTotalCost() {
        double individualPipeCost = calculateIndividualCost();
        double pipeOrderCost = individualPipeCost * pipeQuantity;
        return pipeOrderCost;
    }
   
    /**
     * Gets the double representing the total cost of an individual pipe within this pipe order
     * @return the total cost of an individual pipe
     */
    public double calculateIndividualCost() {
        double percentageExtra = calculatePercentageExtra();
        double pipeVolume = calculatePipeVolume();
        double materialCost = calculateMaterialCost(pipeVolume, grade);
        double pipeCost = materialCost + calculateAdditionalFeatureCost(materialCost, percentageExtra); 
        return pipeCost;
    }
    
    /**
     * Gets the double representing the percentage extra cost of the pipe additional features
     * @return the base cost of the additional features of this pipe
     */
    public double calculatePercentageExtra() {
        return 0;
    } 
    
    /**
     * Gets the double representing the cost of the additional features for the features used by this pipe
     * @param materialCost the cost for the materials of an individual pipe
     * @param percentageExtra the percentage extra based on the additional features of this pipe
     * @return the cost of the additional features for an individual pipe
     */
    public double calculateAdditionalFeatureCost(double materialCost, double percentageExtra) {
        return materialCost * percentageExtra;
    }
    
    /**
     * Gets the double representing the material cost for an individual pipe within this pipe order
     * @param pipeVolume the volume of the pipe
     * @param pipeGrade the grade of the pipe
     * @return the cost for the material of an individual pipe
     */
    public double calculateMaterialCost(double pipeVolume, int pipeGrade) {
        return 0;
    }
    
    /**
     * Gets the integer representing the type of this pipe
     * @return the type of this pipe
     */
    public int getPipeType() { 
        return 0;
    }
    
    /**
     * Gets the string containing all the pipe details for use in the basket ui
     * @return the pipe details
     */
    public String getDetails() {
        String pipeDetailString = "Type " 
                + getPipeType() 
                + " Pipe - [Length: " + length 
                + ", Diameter: " + outerDiameter 
                + ", Colours: " + colours 
                + ", ChemResist: " + chemicalResistance
                + ", Quantity: " + pipeQuantity + "]" 
                + " = " + String.format("£%.2f", calculateTotalCost());
        return pipeDetailString;
    }
}
