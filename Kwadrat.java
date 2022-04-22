  class Kwadrat extends Prostokat implements MoznaWyznaczycPrzekatna{

     Kwadrat(int i) {
         super(i);
     }

      Kwadrat(int i, int i1) {
         super(i);
     }

      @Override
      public double wysokosc() {
          return 0;
      }

      @Override
      public double podstawa() {
          return 1;
      }

      @Override
      public double katNachylenia() {
          return Math.PI/2;
      }

      @Override
      public double bok() {
          return 0;
      }

      @Override
      public double przekatna() {
          return 2 * Math.sqrt(2);
      }

      @Override
      public double wielokrotnoscPrzekatnej(double v) {
         if (v == .5){
             return Math.sqrt(2);
         }
         if (v == 1){
             return 2 * (int) Math.sqrt(2);
         }
         return 0;
      }
  }