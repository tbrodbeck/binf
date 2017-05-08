/**
 * A Class, showing the different abilities of birds in the aviary
 *
 * @author Kevin Trebing
 */
public class Aviary {

   public static void main(String[] args) {
      Dodo dodo = new Dodo();
      // Durch die Typanpassung und die statische Bindung von Variablen wird ability der Oberklasse benutzt
      System.out.println("1: ((Bird)dodo).ability           : " + ((Bird) dodo).ability);
      //Vom Typ Dodo + statisch gebundene Variable -> ability der Klasse Dodo
      System.out.println("2: dodo.ability                   : " + dodo.ability);
      //getAbility() in der Klasse Dodo ruft nur getAbility() der Oberklasse auf welche als Ability nur Fly kennt
      System.out.println("3: dodo.getAbility()              : " + dodo.getAbility());
      Parrot parrot = new Parrot();
      //allAbilities() ist eigentlich überschrieben, die Methode der Unterklasse ruft jedoch allAbilities() der
      //Oberklasse auf die die Ability der Oberklasse (Fly) zurück und gibt zusätzlich die Ability der Klasse Parrot
      // (Talk) zurück
      System.out.println("4: parrot.allAbilities            : " + parrot.allAbilities());
      //gibt statisch gebundene Variable Ability des Parrots zurück
      System.out.println("5: parrot.ability                 : " + parrot.ability);

      Bird carsten = new Dodo();
      //Variable Ability wird statisch gebunden + Compiler geht wegen Typecast davon aus das carsten vom Typ Bird ist
      System.out.println("6: carsten.ability                : " + carsten.ability);
      //Methode allAbilites() wird dynamisch gebunden da hilft auch der Typecast nichts, bei Dodo gibt allAbilities() nur
      //Instanzvariable ability zurück
      System.out.println("7: ((Bird)carsten).allAbilities() : " + ((Bird) carsten).allAbilities());

      Bird einstein = parrot;
      // auch hier wird allAbilities() wieder dynamisch gebunden und benutzt die allAbilities() Methode von Parrot
      // -> ruft allAbilies() von Bird auf und gibt zusätzlich noch eigene ability zurück
      System.out.println("8: einstein.allAbilities()        : " + einstein.allAbilities());
      //in der Klasse Parrot wird getAbilitiy() nicht überladen -> Methode von der Oberklasse Bird wird benutzt
      System.out.println("9: einstein.getAbility()          : " + einstein.getAbility());
      //Instanzvariable wird eigentlich statisch an den Typ der Variable gebunden aber durch Typecast wird sie statisch
      //an Parrot gebunden
      System.out.println("10: ((Parrot)einstein).ability    : " + ((Parrot) einstein).ability);
   }
}
