package blatt06;

import java.util.HashMap;

/**
 * Every instance of Fraction represents a fraction with numerator and
 * decorator.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Fraction extends Number{

   /**
    * The regular expression that defines the String representation of a
    * Fraction.
    */
   public static final String REGEX = "-?\\d+/\\d*[1-9]\\d*";
   private static Fraction fraction;
   private static HashMap<String, Fraction> hashMap = new HashMap<String, Fraction>();

   /**
    * Creates greatest common divisor for a and b.
    * 
    * @param a
    * @param b
    * @return the greatest common divisor for a and b.
    */
   public static int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);

   }

   /**
    * Parses a Fraction from a String by using REGEX. Throws RuntimeException if String s does
    * not contain valid Fraction.
    * 
    * @param s
    *           String to be parsed
    * @return parsed String as Fraction
    * @throws RuntimeException
    *            if String s is not a valid Fraction
    */
   public static Fraction parseFraction(String s) {
      if (!s.matches(REGEX)) {
         throw new RuntimeException("Parsing error");
      }
      String[] splitted = s.split("/");
      return getFraction(Integer.parseInt(splitted[0]),
            Integer.parseInt(splitted[1]));
   }

   private int numerator;

   private int denominator;

   public static Fraction getFraction(int numerator, int denominator) {
       if(denominator == 0) throw new RuntimeException("denominator == 0 is not possible");
       Fraction f = new Fraction(numerator, denominator);
       String key = f.toString();
       Fraction value = hashMap.get(key);
       if(value == null) {
           hashMap.put(key, f);
           return f;
       }
       return value;
   }

   public static Fraction getFraction(int numerator) {
       return getFraction(numerator, 1);
   }
   /**
    * Creates a Fraction object with numerator and denominator 1, cancels the
    * fraction with creation.
    * 
    * @param numerator
    */
   private Fraction(int numerator) {
      this(numerator, 1);
   }

   /**
    * Creates a Fraction object with numerator and denominator, cancels the
    * fraction by creation. Denominator == 0 is not allowed.
    * 
    * @param numerator
    * @param denominator
    */
   private Fraction(int numerator, int denominator) {
      if (denominator == 0) {
         throw new RuntimeException("denominator == 0 is not possible");
      }

      /*
       * creates greatest common divisior.
       */
      int gcd = Fraction.gcd(numerator, denominator);
      /*
       * check sign, make denominator positive
       */
      if (denominator / gcd < 0) {
         gcd *= -1;
      }

      this.numerator = numerator / gcd;

      this.denominator = denominator / gcd;
   }


   /**
    * Adds addend to this Fraction and return the result as a new Fraction.
    * 
    * @param addend
    *           Fraction to be added
    * @return the sum as a new Fraction
    */
   public Fraction add(Fraction addend) {
      return getFraction(this.numerator * addend.denominator
            + this.denominator * addend.numerator, this.denominator
            * addend.denominator);
   }

   /**
    * Divides this Fraction with another Fraction
    * 
    * @param another
    *           Fraction to divide this Fraction by
    * @return quotient as a new Fraction
    */
   public Fraction divide(Fraction another) {
      return getFraction(this.numerator * another.denominator,
            this.denominator * another.numerator);
   }

   /**
    * 
    * @return denominator of this Fraction
    */
   public int getDenominator() {
      return this.denominator;
   }

   /**
    * 
    * @return numerator of this Fraction
    */
   public int getNumerator() {
      return this.numerator;
   }

   /**
    * Multiplies this Fraction with another Fraction
    * 
    * @param another
    *           Fraction to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction another) {
      return getFraction(this.numerator * another.numerator, this.denominator
            * another.denominator);
   }

   /**
    * Multiplies this Fraction with n.
    * 
    * @param n
    *           factor to multiply with
    * @return product as a new Fraction
    */
   public Fraction multiply(int n) {
      return getFraction(this.numerator * n, this.denominator);
   }

   /**
    * Multiplies this Fraction with all other Fraction instances given by
    * factors
    * 
    * @param factors
    *           Fraction instances to multiply this Fraction with
    * @return product as a new Fraction
    */
   public Fraction multiply(Fraction... factors) {
      Fraction result = this;
      for (int i = 0; i < factors.length; i++) {
         result = result.multiply(factors[i]);
      }
      return result;
   }
   
   /**
    * Subtracts subtrahend from this Fraction an returns the result as a new
    * Fraction.
    * 
    * @param subtrahend
    *           to be subtracted Fraction
    * @return the difference as a new Fraction
    */
   public Fraction subtract(Fraction subtrahend) {
      return getFraction(this.numerator * subtrahend.denominator
            - this.denominator * subtrahend.numerator, this.denominator
            * subtrahend.denominator);
   }


   /**
    * Lassen Sie die Klasse Fraction vom vorletzten Aufgabenblatt von der Klasse Number aus der Java API erben und
    * implementieren sie alle abstrakten Methoden.
    *
    * Returns a string representation of this Fraction such as
    * numerator/denominator.
    * 
    * @return This Fraction as a String
    */
   public String toString() {
      return numerator + "/" + denominator;
   }

    /**
     * Returns the value of the specified number as an {@code int},
     * which may involve rounding or truncation.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code int}.
     */
    @Override
    public int intValue() {
        return (int)(numerator / denominator);
    }

    /**
     * Returns the value of the specified number as a {@code long},
     * which may involve rounding or truncation.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code long}.
     */
    @Override
    public long longValue() {
        return (long)(numerator / denominator);
    }

    /**
     * Returns the value of the specified number as a {@code float},
     * which may involve rounding.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code float}.
     */
    @Override
    public float floatValue() {
        return (float)(numerator / denominator);
    }

    /**
     * Returns the value of the specified number as a {@code double},
     * which may involve rounding.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return (double)(numerator / denominator);
    }
}
