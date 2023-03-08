import java.util.ArrayList;

public class ComputingStatistics {
   /**
   * The ArrayList containing all of the loan data.
   */
   private ArrayList<Loan> data;
   
   /**
    * Creates a new ComputingStatistics object with an empty ArrayList 
    */
   public ComputingStatistics() {
      data = new ArrayList<Loan>();
   }
   
   /**
    * Creates a new ComputingStatistics object with the data passed in
    */
   public ComputingStatistics(ArrayList<Loan> d) {
      data = d;
   }
   
   /**
    * Calclates the total amount funded from all of the loans in the file.
    * @return the total loan amount.
    */
   public double totalAmount() {
      double amount = 0.0;
      for(int i = 0; i < data.size(); i++) {
         amount = amount + data.get(i).getLoanAmount();
      }
      return amount;
   }
   
   public double avgLoan(){
       double sum = 0.0;
       for (int i = 0; i < data.size(); i++){
           sum += data.get(i).getLoanAmount();
       }
       return (double) sum / data.size();
   }
   public double largestLoan(){
       double largest = 0.0;
       for (Loan loan: data){
           if (loan.getLoanAmount() > largest){
               largest = loan.getLoanAmount();
           }
       }
       return largest;
   }
   public double smallestLoan(){
       double smallest = data.get(0).getLoanAmount();
       for (Loan loan: data){
           if (loan.getLoanAmount() < smallest){
               smallest = loan.getLoanAmount();
           }
       }
       return smallest;
   }
   public String largestLoanCountry(){
       int largestIndex = 0;
       for (int i = 0; i < data.size(); i ++){
           if (data.get(i).getLoanAmount() > data.get(largestIndex).getLoanAmount()){
               largestIndex = i;
           }
       }
       return data.get(largestIndex).getCountry();
   }
   public String smallestLoanCountry(){
       int smallestIndex = 0;
       for (int i = 0; i < data.size(); i ++){
           if (data.get(i).getLoanAmount() < data.get(smallestIndex).getLoanAmount()){
               smallestIndex = i;
           }
       }
       return data.get(smallestIndex).getCountry();
   }
   public double avgDaysToFund(){
       int numDays = 0;
       for (int i = 0; i < data.size(); i++){
           numDays += data.get(i).getDaysToFund();
       }
       return (double) numDays / data.size();
   }
   public double largestLoanKenya(){
       //iterate through every loan, find ones that are kenyan, and see if their loan amount is greater
       //than the current largest kenyan loan
       ArrayList <Loan> kenyanLoans = new ArrayList <Loan>();
       for (int i = 0; i < data.size(); i ++){
           if (data.get(i).getCountry().equals("Kenya")){
               kenyanLoans.add(data.get(i));
           }
       }
       double largest = Double.MIN_VALUE;
       for (Loan loan: kenyanLoans){
           if (loan.getLoanAmount() > largest){
               largest = loan.getLoanAmount();
           }
       }
       return largest;
   }
   public double avgLoanPhilippines(){
       double sum = 0.0;
       int count = 0;
       for (Loan loan: data){
           if (loan.getCountry().equals("Philippines")){
               sum += loan.getLoanAmount();
               count++;
           }
       }
       return (double) sum / count;
   }
   public String longestToFundCountry(){
       Loan longest = data.get(0);
       for (Loan loan: data){
           if (loan.getDaysToFund() > longest.getDaysToFund()){
               longest = loan;
           }
       }
       return longest.getCountry();
   }
   public String mostLoansFunded(){
       int numKenyan = 0;
       int numElSalvadorian = 0;
       for (Loan loan: data){
           if (loan.getCountry().equals("Kenya")){
               numKenyan++;
           }
           else if (loan.getCountry().equals("El Slavador")){
               numElSalvadorian++;
           }
       }
       String more;
       if (numKenyan > numElSalvadorian){
           return "Kenya had more loans";
       }
       else if (numElSalvadorian > numKenyan){
           return "El Salvador had more loans";
       }
       else{
           return "There is a tie";
       }
   }
   public double variance(){
       double avg = avgLoan();
       
       double sum = 0.0;
       for (Loan loan: data){
           sum += Math.pow((loan.getLoanAmount() - avg), 2);
       }
       double var = (double) sum / data.size();
       return var;
   }
   public double standardDeviation(){
       return Math.sqrt(variance());
   }
   public boolean empiricalRule(){
       double SD = standardDeviation();
       double mean = avgLoan();
       double firstSDP = mean + SD;
       double firstSDN = mean - SD;
       double secondSDP = mean + SD * 2;
       double secondSDN = mean - SD * 2;
       double thirdSDP = mean + SD * 3;
       double thirdSDN = mean - SD * 3;
       int countFirst = 0;
       int countSecond = 0;
       int countThird = 0;
       for (int i = 0; i < data.size(); i++){
           if (data.get(i).getLoanAmount() <= firstSDP && data.get(i).getLoanAmount() >= firstSDN){
               countFirst++;
           }
       }
       for (int i = 0; i < data.size(); i++){
           if (data.get(i).getLoanAmount() <= secondSDP && data.get(i).getLoanAmount() >= secondSDN){
               countSecond++;
           }
       }
       for (int i = 0; i < data.size(); i++){
           if (data.get(i).getLoanAmount() <= thirdSDP && data.get(i).getLoanAmount() >= thirdSDN){
               countThird++;
           }
       }
       double firstPercent = (double) countFirst / data.size();
       double secondPercent = (double) countSecond / data.size();
       double thirdPercent = (double) countThird / data.size();
       if (firstPercent <= 0.68 && secondPercent <= 0.95 && thirdPercent <= 0.997){
           return true;
       }
       return false;
    }
}