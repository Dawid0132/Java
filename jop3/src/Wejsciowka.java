import java.util.*;
public class Wejsciowka {
    public static class Prostokat extends Wejsciowka{
        public Prostokat (double bok1, double bok2) {

        }

        public Prostokat() {

        }

        double przekatna() {

            return 0;
        }

        public int przekatna(double v) {
            return 0;
        }
    }
    public static class Kwadrat extends Prostokat {
         public Kwadrat(double bok1, double bok11) {
            super();

        }

        public Kwadrat(double bok1) {

        }
        public double przekatna() {

            return 0;
        }
    }
    public static void main(String[] args) {
        // oczywiście ma też działać po zmianie tych wartości
        double bok1 = 1, bok2 = 2;
        Prostokat prostokat1 = new Prostokat(bok1, bok2);
        Kwadrat prostokat2 = new Kwadrat(bok1, bok1);
        Prostokat prostokat3 = new Kwadrat(bok1);

        if (prostokat2.przekatna() == ((Kwadrat) prostokat3).przekatna())
            System.out.println("To powinno się wydrukować 1 (za 1 p.)");
        if (prostokat1.przekatna(2.5) == (Math.sqrt((bok1 * bok1) + (bok2 * bok2)) * 2.5))
            System.out.println("To powinno się wydrukować 2 (za 1 p.)");
        if ((int) (bok1 * Math.sqrt(2) * 2) == prostokat3.przekatna(2))
            System.out.println("To powinno się wydrukować 3 (za 2 p.)");
        if (!prostokat1.equals(prostokat2))
            System.out.println("To powinno się wydrukować 4 (za 1 p.)");
        ArrayList lista1 = new ArrayList();
        lista1.add(prostokat1);
        lista1.add(prostokat2);
        lista1.add(prostokat3);
        lista1.remove(prostokat3);
        if (lista1.contains(prostokat3))
            System.out.println("To powinno się wydrukować 5 (za 2 p.)");
    }

}
