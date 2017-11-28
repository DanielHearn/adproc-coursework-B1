package longpipes;

/**
 * Type four pipe class that contains all pipe properties that are specific to the type four pipe
 * 
 * @author dan 801685
 */
public class TypeFourPipe extends TypeThreePipe{
    private final Boolean innerInsulation;
    
    /**
     * Construct a new pipe with the common pipe specifications used by all
     * other pipe types
     * 
     * @param inputLength the double representing the length of this pipe
     * @param inputDiameter the double representing the outer diameter of this
     *                      pipe
     * @param pipeGrade the integer representing the plastic grade of this pipe
     * @param pipeColours the integer representing the number of colours being 
     *                    used in this pipe
     * @param pipeInnerInsulation the boolean representing if this pipe has 
     *                            inner insulation
     * @param pipeChemicalResistance the boolean representing if this pipe has
     *                               chemical resistance properties
     * @param pipeQuantity the integer representing the quantity of this pipe
     *                     being ordered
     */
    public TypeFourPipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeInnerInsulation, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
        innerInsulation = pipeInnerInsulation;
    }
    
    /**
     * Gets the integer representing the type of this pipe
     * @return the type of this pipe
     */
    @Override
    public int getPipeType() { 
        return 4;
    }
    
    /**
     * Gets the boolean representing the inner insulation property of this pipe
     * 
     * @return the inner insulation property of this pipe
     */
    public Boolean getInnerInsulation() {
        return innerInsulation;
    }
    
    /**
     * Get the double representing the percentage additional cost of having 
     * inner insulation in this pipe
     * 
     * @return the additional cost of inner insulation
     */
    public double getInnerInsulationCost() {
        return 0.13;
    }
    
    /**
     * Gets the double representing the percentage extra cost of the pipe
     * additional features
     * 
     * @return the base cost of the additional features of this pipe
     */
    @Override
    public double calculatePercentageExtra() {
        double percentageExtra = 0;

        percentageExtra += getTwoColourCost();
        
        percentageExtra += getInnerInsulationCost();
        
        if(getChemicalResistance()) {
            percentageExtra += getChemicalResistanceCost();
        }
        
        return percentageExtra;
    } 
}
