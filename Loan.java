
/**
 * Write a description of class Loan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Loan
{
    private int id;
    private double loanAmount;
    private String country;
    private int daysToFund;
    private int numLenders;
    
    public Loan(int id, double loanAmount, String country, int daysToFund, int numLenders){
       this.id = id;
       this.loanAmount = loanAmount;
       this.country = country;
       this.daysToFund = daysToFund;
       this.numLenders = numLenders;
    }
    
    // getter/accesor methods
    public int getID(){
        return id;
    }
    public double getLoanAmount(){
        return loanAmount;
    }
    public String getCountry(){
        return country;
    }
    public int getDaysToFund(){
        return daysToFund;
    }
    public int getNumLenders(){
        return numLenders;
    }
    
    // setter/modify method
    public void setID(int id){
        this.id = id;
    }
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setDaysToFund(int daysToFund){
        this.daysToFund = daysToFund;
    }
    public void setNumLenders(int numLenders){
        this.numLenders = numLenders;
    }
}
