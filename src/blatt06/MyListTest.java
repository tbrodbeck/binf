package blatt06;

public class MyListTest {

   public static void main(String[] args) {

      /*
       * not absolute requirements
       */
      MyList<String> l = new MyList<>();
      System.out.println("Test clone() in MyList...");
      System.out.println("...test not absolute requirements...");
      Assert.assertTrue(l.clone() != l);
      Assert.assertTrue(l.clone().getClass() == l.getClass());
      Assert.assertTrue(l.clone().equals(l));
      /*
       * is anything copied at all?
       */
      l.add("A");
      MyList<String> clone = l.clone();
      System.out.println("...test if inner structure is copied/clones");
      Assert.assertEquals("A", clone.elem());
      /*
       * test for independence
       */
      System.out.println("...test independence...");
      l.add("B");
      clone.advance();
      Assert.assertTrue(clone.endpos());
      clone.add("C");
      clone.add("D");
      l.advance();
      l.advance();
      Assert.assertTrue(l.endpos());
      /* l now has A B, clone has A C D */
      l.reset();
      l.delete();
      clone.reset();
      Assert.assertEquals("A", clone.elem());
      System.out.println("...finished.");

   }
}
