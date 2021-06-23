package Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * Klasse zum Speichern eines einzelnen Satelliten
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
@JsonInclude(Include.NON_NULL)
public class Satellit {
    private String name = null;
    private List<Transponder> transponders = null;
    //Für View
    private List<Channel> channels = null;
    private Integer count = null;
    /**
     * Konstruktor für Klasse Satellit
     * @param transponders, Liste an Transpondern vom Satelliten
     * @param name, Name des Satelliten
     * @post Instanz von Satellit erstellt
     */
    public Satellit(List<Transponder> transponders, String name) {
        this.transponders = transponders;
        this.name = name;
    }
    /**
     * Get-Funktion zum Laden der gespeicherten Transponder-Liste
     * @return transponders, die aktuell gespeicherte Transponder-Liste
     */
    public List<Transponder> getTransponders() {
        return transponders;
    }
    /**
     * Get-Funktion zum Laden des gespeicherten namen
     * @return name, der aktuell gespeicherte Name
     */
    public String getName() {
        return name;
    }
    /**
     * Set-Funktion zum überschreiben der Transponder-Liste
     * @param transponders, setzen von Transponder-Liste
     */
    public void setTransponders(List<Transponder> transponders) {
        this.transponders = transponders;
    }
    /**
     * Set-Funktion zum Überschreiben des Namen
     * @param name, Name des Satelliten
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get-Funktion zum Laden des gespeicherten namen
     * @return name, der aktuell gespeicherte Name
     */
    public List<Channel> getChannels() {
        return channels;
    }
    /**
     * Get-Funktion zum Laden der gespeicherten Channel-Liste
     * @return channels, die aktuell gespeicherte Channel-Liste
     */
    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
    /**
     * Get-Funktion zum Laden des gespeicherten Anzahl
     * @return count, des aktuell gespeicherten Anzahl
     */
    public Integer getCount() {
        return count;
    }
    /**
     * Set-Funktion zum überschreiben des counts
     * @param count, setzen von count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}

