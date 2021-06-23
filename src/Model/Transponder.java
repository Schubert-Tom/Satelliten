package Model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Klasse zum Speichern eines einzelnen Transponder
 * @author 4328112, 1319658, 1060449
 * @version 2.1
 */
@JsonInclude(Include.NON_NULL)
public class Transponder {
    private String pol;
    private String orbital;
    private String freq;
    private String sym;
    private List<Channel> channels;
    //Für View
    private String sat;
    private Satellit satellit = null;
    private Integer count = null;
    /**
     * Get-Funktion zum Laden des gespeicherten Satellitenname
     * @return sat, der aktuelle Satellitenname
     */
    public String getSat() {
        return sat;
    }
    /**
     * Get-Funktion zum Laden der gespeicherten Channel-Liste
     * @return channels, die aktuell gespeicherte Channel-Liste
     */
    public List<Channel> getChannels() {
        return channels;
    }
    /**
     * Set-Funktion zum Überschreiben des pol Paramteres
     * @param pol, setzen pol Feld
     */
    public void setPol(String pol) {
        this.pol = pol;
    }
    /**
     * Set-Funktion zum Überschreiben des sat Paramteres
     * @param sat, setzen sat Feld
     */
    public void setSat(String sat) {
        this.sat = sat;
    }
    /**
     * Set-Funktion zum Überschreiben des orbital Feldes
     * @param orbital, setzen von orbital Felde
     */
    public void setOrbital(String orbital) {
        this.orbital = orbital;
    }
    /**
     * Set-Funktion zum Überschreiben des freq Feldes
     * @param freq, setzen von freq Felde
     */
    public void setFreq(String freq) {
        this.freq = freq;
    }
    /**
     * Set-Funktion zum Überschreiben des sym Feldes
     * @param sym, setzen von sym Felde
     */
    public void setSym(String sym) {
        this.sym = sym;
    }
    /**
     * Set-Funktion zum Überschreiben der Channel-Liste
     * @param channels, setzen von Channel-Liste
     */
    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
    /**
     * Get-Funktion zum Laden des pol Feldes
     * @return transponders, aktuell gespeichertes pol Feldes
     */
    public String getPol() {
        return pol;
    }
    /**
     * Get-Funktion zum Laden des pol Feldes
     * @return transponders, aktuell gespeichertes pol Feldes
     */
    public String getOrbital() {
        return orbital;
    }
    /**
     * Get-Funktion zum Laden des orbital Feldes
     * @return transponders, aktuell gespeichertes orbital Feld
     */
    public String getFreq() {
        return freq;
    }
    /**
     * Get-Funktion zum Laden des freq Feldes
     * @return transponders, aktuell gespeichertes freq Feld
     */
    public String getSym() {
        return sym;
    }
    /**
     * Get-Funktion zum Laden des orbital Feldes
     * @return transponders, aktuell gespeichertes orbital Feld
     */
    public Satellit getSatellit() {
        return satellit;
    }
    /**
     * Set-Funktion zum überschreiben des Satelliten Namen
     * @param satellit, setzen von Satelliten Namen
     */
    public void setSatellit(Satellit satellit) {
        this.satellit = satellit;
    }
    /**
     * Get-Funktion zum Laden des count Feldes
     * @return transponders, aktuell gespeichertes count Feld
     */
    public Integer getCount() {
        return count;
    }
    /**
     * Set-Funktion zum überschreiben des count Feldes
     * @param count, setzen von count Feld
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
