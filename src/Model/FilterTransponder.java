package Model;

public class FilterTransponder extends Filterarg {
    String kriterium;
    public void filter(Transponder transponder){
        // filtert übergeben daten nach kriterium
        // Streamof(transponder).filter(n-> n.equals(this.kriterium)) // igw so ka
    }
}