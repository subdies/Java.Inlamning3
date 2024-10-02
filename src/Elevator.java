public class Elevator {

    private int våning = 5; // Hissen är från start på våning 5.


    public void goTo(int nyVåning) {

        if (nyVåning < -2 || nyVåning > 10) { // Kollar att inmatningen är inom gränserna eller samma som hissens aktulla våning.
            System.out.println("Ange en giltig våning att åka till (-2 till 10)");
        }else if (nyVåning == våning){
            System.out.println("Du befinner dig redan på våning " + nyVåning);
        } else {
            if (nyVåning < våning) System.out.println("Du åker nu ner till våning " + nyVåning);
            else if (nyVåning > våning) System.out.println("Du åker nu upp till våning " + nyVåning);
            våning = nyVåning;
        }
    }
    public void where() { // Skriver ut vart hissen är.
        System.out.println("Hissen befinner sig på våning: " + våning);

    }
    public int getVåning(int våning) {
        return våning;
    }
    public void setVåning(int våning) {
            this.våning = våning;

    }
}
