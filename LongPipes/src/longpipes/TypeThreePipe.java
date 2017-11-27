package longpipes;

/**
 * Type three pipe class that contains all pipe properties that are specific to the type three pipe
 * @author dan 801685
 */
public class TypeThreePipe extends Pipe{
    
    /**
     * Construct a new pipe with the common pipe specifications used by all other pipe types
     * @param inputLength the double representing the length of this pipe
     * @param inputDiameter the double representing the outer diameter of this pipe
     * @param pipeGrade the integer representing the plastic grade of this pipe
     * @param pipeColours the integer representing the number of colours being used in this pipe
     * @param pipeChemicalResistance the boolean representing if this pipe has chemical resistance properties
     * @param pipeQuantity the integer representing the quantity of this pipe being ordered
     */
    public TypeThreePipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
     * Gets the integer representing the type of this pipe
     * @return the type of this pipe
     */
    @Override
    public int getPipeType() { 
        return 3;
    }
    
    /**
     * Get the double representing the percentage additional cost of having two colours on this pipe
     * @return the additional cost for two colours
     */
    public double getTwoColourCost() {
        return 0.16;
    }
    
    /**
     * Gets the double representing the percentage extra cost of the pipe additional features
     * @return the base cost of the additional features of this pipe
     */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;
        
        percentageExtra += getTwoColourCost();
        
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
