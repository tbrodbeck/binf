package blatt08;
import java.io.*;
import java.util.HashMap;

/**
 * Class to calculate the Fibonacci number. Uses a HashMap to reduce the
 * calculation cost.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Fibonacci {

   private final static HashMap<Integer, Long> fibonacciHash;

   /**
    * Fill HashMap with initial key-value-pairs.
    */
   static {
      File f = new File("fibhash.ser");
      HashMap<Integer, Long> tempFibhash = null;
      if (f.isFile()) {
         try{
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("fibhash.ser"));
            tempFibhash = (HashMap<Integer,Long>)oin.readObject();
         }
         catch(ClassNotFoundException e) {
            throw new RuntimeException("Klasse HashMap nicht gefunden");
         }
         catch(IOException e) {
            e.printStackTrace();
         }
      }
      else {
         tempFibhash = new HashMap<>();
         tempFibhash.put(0, 0L);
         tempFibhash.put(1, 1L);
      }
      fibonacciHash = tempFibhash;
   }

   /**
    * Calculates the fibonacci value of n.
    * 
    * @param n
    *           a natural number >= 0 to calculate the fibonacci value of
    * 
    * @return fibonacci value of n
    */
   public static long fibonacci(int n) {
      if (n < 0) {
         throw new IllegalArgumentException("n = " + n);
      }
      return getFibonacci(n);
   }

   private static long getFibonacci(int n) {
      if (fibonacciHash.containsKey(n)) {
         return fibonacciHash.get(n);
      } else {
         long nMinus1 = getFibonacci(n - 1);
         long nMinus2 = getFibonacci(n - 2);
         long fibonacci = nMinus1 + nMinus2;

         fibonacciHash.put(n, fibonacci);
         return fibonacci;
      }
   }

   public static void main(String[] args) {
      if (args.length != 1) {
         printUsage();
      }
      try {
         System.out.println(fibonacci(Integer.parseInt(args[0])));

      } catch (IllegalArgumentException ex) {
         printUsage();
      }
      File f = new File("fibhash.ser");
      if(f.exists()) f.delete();
      try{
         f.createNewFile();
      }
      catch(IOException e) {
         e.printStackTrace();
      }
      try {
         ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(f));
         oout.writeObject(fibonacciHash);
      }
      catch (FileNotFoundException e){
         e.printStackTrace();
      }
      catch(IOException e) {
         e.printStackTrace();
      }
   }

   private static void printUsage() {
      System.out.println("java calc/Fiboncci n");
      System.out.println("n must be a natural number >= 0");
   }

}
