package longpipes;

/**
 * Type one pipe class that contains all pipe properties that are specific to the type one pipe
 * @author dan 801685
 */
public class TypeOnePipe extends Pipe{
    
    /**
     * Construct a new pipe with the common pipe specifications used by all other pipe types
     * @param inputLength the double representing the length of this pipe
     * @param inputDiameter the double representing the outer diameter of this pipe
     * @param pipeGrade the integer representing the plastic grade of this pipe
     * @param pipeChemicalResistance the boolean representing if this pipe has chemical resistance properties
     * @param pipeQuantity the integer representing the quantity of this pipe being ordered
     */
    public TypeOnePipe(double inputLength, double inputDiameter, int pipeGrade, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, 0, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
     * Gets the integer representing the type of this pipe
     * @return the type of this pipe
     */
    @Override
    public int getPipeType() { 
        return 1;
    }
    
    /**
     * Gets the double representing the percentage extra cost of the pipe additional features
     * @return the base cost of the additional features of this pipe
     */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;
        
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
            case 1:
                materialCost = pipeVolume * 0.4;
                break;
            case 2:
                materialCost = pipeVolume * 0.6;
                break;
            case 3:
                materialCost = pipeVolume * 0.75;
                break;
            default:
                materialCost = pipeVolume * 0.4;
                break;
        }
        return materialCost;
    }
}
