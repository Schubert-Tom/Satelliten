package Model;

public class FilterChannel extends Filterarg {
    String kriterium;
    public void filter(Channel channel){
        // filtert übergeben daten nach kriterium
        // Streamof(channel).filter(n-> n.equals(this.kriterium)) // igw so ka
    }
}
