package longpipes;

/**
 * Type four pipe class that contains all pipe properties that are specific to the type four pipe
 * @author dan 801685
 */
public class TypeFourPipe extends TypeThreePipe{
    private final Boolean innerInsulation;
    
    public TypeFourPipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeInnerInsulation, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
        innerInsulation = pipeInnerInsulation;
    }
    
    /**
    * @return String containing all the pipe details
    */
    @Override
    public int getPipeType() { 
        return 4;
    }
    
    /**
    * @return The pipe's inner insulation
    */
    public Boolean getInnerInsulation() {
        return innerInsulation;
    }
    
    /**
    * @return The inner insulation cost
    */
    public double getInnerInsulationCost() {
        return 0.13;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
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
