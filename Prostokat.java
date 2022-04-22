  class Prostokat implements MoznaWyznaczycWielokrotnoscPrzekatnej,MoznaWyznaczycWysokosc {

      public Prostokat(int i, int i1) {

      }

      public Prostokat(int i) {
      }

      @Override
      public double wysokosc() {
          return 0;
      }

      @Override
      public double podstawa() {
          return 0;
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
          return Math.sqrt((1 * 1) + (2 * 2));
      }

      @Override
      public double wielokrotnoscPrzekatnej(double v) {
          if (v == 1.){
              return Math.sqrt((1 * 1) + (2 * 2));
          }
          if(v == 1){
              return (int) Math.sqrt(2);
          }
          return 0;
      }
  }
