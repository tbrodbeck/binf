/**
 * A Class, showing the different abilities of birds in the aviary
 *
 * @author Kevin Trebing
 */
public class Aviary {

   public static void main(String[] args) {
      Dodo dodo = new Dodo();
      // Variablen statisch gebunden + Typecast
      System.out.println("1: ((Bird)dodo).ability           : " + ((Bird) dodo).ability);
      //Vom Typ Dodo + statisch gebundene Variabel
      System.out.println("2: dodo.ability                   : " + dodo.ability);
      //getAbility() in der Klasse Dodo ruft nur getAbility() von Bird/der Oberklasse auf welche als Ability nur Fly kennt
      System.out.println("3: dodo.getAbility()              : " + dodo.getAbility());
      Parrot parrot = new Parrot();
      //allAbilities gibt allAbilities der Oberklasse (also die Ability der Oberklasse/Fly) + und die Ability der Klasse
      //Parrot/Talk zurück
      System.out.println("4: parrot.allAbilities            : " + parrot.allAbilities());
      //
      System.out.println("5: parrot.ability                 : " + parrot.ability);

      Bird carsten = new Dodo();
      System.out.println("6: carsten.ability                : " + carsten.ability);
      System.out.println("7: ((Bird)carsten).allAbilities() : " + ((Bird) carsten).allAbilities());

      Bird einstein = parrot;
      System.out.println("8: einstein.allAbilities()        : " + einstein.allAbilities());
      System.out.println("9: einstein.getAbility()          : " + einstein.getAbility());
      System.out.println("10: ((Parrot)einstein).ability    : " + ((Parrot) einstein).ability);
   }
}
