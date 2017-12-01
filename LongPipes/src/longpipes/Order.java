package longpipes;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Class representing an order of pipes 
 * 
 * @author Dan 801685
 * @author Lee 750834
 */
public class Order {

    ArrayList<Pipe> orderedPipes = new ArrayList<>();
    private int orderNumber;
    ArrayList<String> invoiceStrings = new ArrayList<>();

    /**
     * Creates a new order and initialises the order number to 1
     */
    public Order() {
        orderNumber = 1;
    }

    /**
     * Adds a new pipe input from the parameter into the ordered pipes arraylist
     * 
     * @param inputPipe the pipe being added to this order
     * @author Dan 801685
     */
    public void addPipe(Pipe inputPipe) {
        int orderPosition = orderedPipes.size();
        orderedPipes.add(orderPosition, inputPipe);
    }

    /**
     * Calls the order to remove the input pipe based on the arraylist index
     *
     * @param pipeIndex the pipe index 
     * @author Dan 801685
     */
    public void removePipe(int pipeIndex) {
        orderedPipes.remove(pipeIndex);
    }
    
    /**
     * Gets the double representing the total cost of this order
     * 
     * @return the total cost of this order
     * @author Dan 801685
     */ 
    public double totalCost() {
        double totalCost = 0;
        for (int pipe = 0; pipe < orderedPipes.size(); pipe++) {
            totalCost += orderedPipes.get(pipe).calculateTotalCost();
        }
        totalCost = Double.parseDouble(new DecimalFormat("##.##").format(totalCost));
        return totalCost;
    }

    /**
     * Gets the integer representing the number of individual orders within
     * this order
     * 
     * @return the number of individual orders
     * @author Dan 801685
     */
    public int getOrderedPipesLength() {
        return orderedPipes.size();
    }

    /**
     * Gets the integer representing the order number
     * 
     * @return the order number
     * @author Dan 801685
     */ 
    public int getOrderNumber() {
        return orderNumber;
    }    
    
    /**
     * Gets a string representing a pipes details for use in the invoice text
     * 
     * @param currentPipe the current pipe
     * @param currentPipeType the current pipe type
     * @param inputString the main string content
     * @param inputDouble the double value to be placed at the end of the string
     * @return The string formatted for use in the invoice based on pipe details
     * @author Dan 801685
     */
    public String genInvoicePipeString(Pipe currentPipe, String currentPipeType, String inputString, double inputDouble) {
        String startString = currentPipeType + ": " + inputString + ": ";
        String formattedNumber = String.format("£%.2f", inputDouble);
        String invoiceString = formatInvoice(startString) + formattedNumber;
        return invoiceString;
    }
    
    /**
     * Gets a string representing a pipes details for use in the invoice text
     * 
     * @param currentPipe the current pipe
     * @param currentPipeType the current pipe type
     * @param inputString the main string content
     * @param inputInt the integer value to be placed at the end of the string
     * @return The string formatted for use in the invoice based on pipe details
     * @author Dan 801685
     */
    public String genInvoicePipeString(Pipe currentPipe, String currentPipeType, String inputString, int inputInt) {
        String startString = currentPipeType + ": " + inputString + ": ";
        String formattedNumber = Integer.toString(inputInt);
        String invoiceString = formatInvoice(startString) + formattedNumber;
        return invoiceString;
    }
    
    /**
     * Gets the string representing the invoice text
     * 
     * @param orderNo the number of the order
     * @return the invoice details
     * @author Lee 750834
     * @author Dan 801685
     */
    public String getInvoice(int orderNo) {
        invoiceStrings.clear();
        String invoice = "";
        String linebreak = "";
        if (orderedPipes.size() > 0) {
            orderNumber ++;

            setInvoicePipeDetails();

            String orderTotal = String.format("£%.2f", totalCost());
            orderTotal = formatInvoice("Total Basket Cost:") + orderTotal;

            String orderRef = formatInvoice("Order Ref No:") + Integer.toString(orderNo);
            String[] dateTime = LongPipesSystemGUI.getDateTime();
            String date = formatInvoice("Date:") + dateTime[0];
            String time = formatInvoice("Time:") + dateTime[1];
            String thankyouText = formatInvoice("Thanks for shopping with LongPipes"); 

            invoiceStrings.add(orderRef);
            invoiceStrings.add(orderTotal); 
            invoiceStrings.add(date);
            invoiceStrings.add(time);
            invoiceStrings.add(linebreak);
            invoiceStrings.add(thankyouText);

            for (int i = 0; i < invoiceStrings.size(); i++) {
                invoice +=  invoiceStrings.get(i) + "\n";
            }

        } else {
            invoice = "Enter your order before attempting to complete your order.";
        }

        return invoice;
    }
    
    /**
     * Sets the invoice pipe details based on each of the ordered pipes
     * 
     * @author Dan 801685
     */
    public void setInvoicePipeDetails() {
        for (int i = 0; i < orderedPipes.size(); i++) {
            Pipe currentPipe = orderedPipes.get(i);
            String currentPipeType = "Pipe Order " + (i+1);
            double individualPipeCost = currentPipe.calculateIndividualCost();
            double pipeMaterialCost = currentPipe.calculateMaterialCost(currentPipe.calculatePipeVolume(), currentPipe.getGrade());
            double pipeExtraCost = currentPipe.calculateAdditionalFeatureCost(pipeMaterialCost, currentPipe.calculatePercentageExtra());
            int pipeQuantity = currentPipe.getPipeQuantity();
            double totalCost = currentPipe.calculateTotalCost();
            invoiceStrings.add(currentPipe.getInvoiceDetails());
            invoiceStrings.add(genInvoicePipeString(currentPipe, currentPipeType, "Individual Pipe Cost", individualPipeCost));
            invoiceStrings.add(genInvoicePipeString(currentPipe, currentPipeType, "Pipe Material Cost", pipeMaterialCost));
            invoiceStrings.add(genInvoicePipeString(currentPipe, currentPipeType, "Pipe Additional Feature Cost", pipeExtraCost));
            invoiceStrings.add(genInvoicePipeString(currentPipe, currentPipeType, "Quantity of Pipes in Order", pipeQuantity));
            invoiceStrings.add(genInvoicePipeString(currentPipe, currentPipeType, "Total Pipe Order Cost", totalCost));
            invoiceStrings.add("---------------------------------------------");
        }
    }
   

    /**
     * Gets the string representing the formatted invoice data
     * 
     * @param inputString the string to be formatted
     * @return the formated string
     * @author Lee 750834
     */
    public static String formatInvoice(String inputString) {
        return String.format("%1$-" + 55 + "s", inputString);
    }

    /**
     * Gets the arraylist of pipes that have been ordered
     * 
     * @return the ordered pipes 
     * @author Dan 801685
     */
    public ArrayList<Pipe> getOrderedPipes() {
        return orderedPipes;
    }
}
