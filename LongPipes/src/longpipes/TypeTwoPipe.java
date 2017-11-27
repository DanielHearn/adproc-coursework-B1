package longpipes;

/**
 * Type two pipe class that contains all pipe properties that are specific to the type two pipe
 * @author dan 801685
 */
public class TypeTwoPipe extends Pipe{
    
    public TypeTwoPipe(double inputLength, double inputDiameter, int pipeGrade, int pipeColours, boolean pipeChemicalResistance, int pipeQuantity) {
        super(inputLength, inputDiameter, pipeGrade, pipeColours, pipeChemicalResistance, pipeQuantity);
    }
    
    /**
    * @return String containing all the pipe details
    */
    @Override
    public int getPipeType() { 
        return 2;
    }
    
    /**
    * @return The additional cost for one colour
    */
    public double getOneColourCost() {
        return 0.12;
    }
    
    /**
    * @return The percentage extra costs based on the pipe additional costs
    */
    @Override
     public double calculatePercentageExtra() {
        double percentageExtra = 0;

        percentageExtra += getOneColourCost();
        
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
            case 2:
                materialCost = pipeVolume * 0.6;
                break;
            case 3:
                materialCost = pipeVolume * 0.75;
                break;
            case 4:
                materialCost = pipeVolume * 0.8;
                break;
            default:
                materialCost = pipeVolume * 0.6;
                break;
        }
        return materialCost;
    }
}
