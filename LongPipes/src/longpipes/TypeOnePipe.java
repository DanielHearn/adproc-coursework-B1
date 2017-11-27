package longpipes;

/**
 * Type one pipe class that contains all pipe properties that are specific to the type one pipe
 * @author dan 801685
 */
public class TypeOnePipe extends Pipe{
    
    public TypeOnePipe(double inputLength, double inputDiameter, int pipeGrade, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, 0, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
    * @return String containing all the pipe details
    */
    @Override
    public int getPipeType() { 
        return 1;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
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
     * @param pipeVolume The volume of the pipe
     * @param pipeGrade The grade of the pipe
    * @return The cost for the material of an individual pipe
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
