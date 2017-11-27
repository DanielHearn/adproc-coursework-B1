package longpipes;

/**
 * Type five pipe class that contains all pipe properties that are specific to the type five pipe
 * @author dan 801685
 */
public class TypeFivePipe extends TypeFourPipe{
    private final Boolean outerReinforcement;
    
    /**
     * Construct a new pipe with the common pipe specifications used by all other pipe types
     * @param inputLength the double representing the length of this pipe
     * @param inputDiameter the double representing the outer diameter of this pipe
     * @param pipeGrade the integer representing the plastic grade of this pipe
     * @param pipeColours the integer representing the number of colours being used in this pipe
     * @param pipeChemicalResistance the boolean representing if this pipe has chemical resistance properties
     * @param pipeQuantity the integer representing the quantity of this pipe being ordered
     */
    public TypeFivePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, true, pipeChemicalResistance, pipeQuantity);
        outerReinforcement = true;
    }
    
    /**
     * Gets the integer representing the type of this pipe
     * @return the type of this pipe
     */
    @Override
    public int getPipeType() { 
        return 5;
    }
    
    /**
     * Gets the boolean representing the outer reinforcement property of this pipe
     * @return the outer reinforcement property of this pipe
     */
    public Boolean getOuterReinforcement() {
        return outerReinforcement;
    }
    
    /**
     * Get the double representing the percentage additional cost of having outer reinforcement on this pipe
     * @return the additional cost for outer reinforcement
     */
    public double getOuterReinforcementCost() {
        return 0.17;
    }
    
    /**
     * Gets the double representing the percentage extra cost of the pipe additional features
     * @return the base cost of the additional features of this pipe
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
     * Gets the double representing the material cost for an individual pipe within this pipe order
     * @param pipeVolume the volume of the pipe
     * @param pipeGrade the grade of the pipe
     * @return the cost for the material of an individual pipe
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
