package Model;

import java.util.List;
/**
 * Klasse beschreibt die gesamte Datenstruktur die von der Dateneingabe geladen wurde
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
public class Data {
    // Liste zum speichern der Satelliten
    private List<Satellit> data;
    /**
     * Get-Funktion zum Laden der gespeicherten Satelliten-Liste
     * @return data, die aktuell gespeicherte Satelliten-Liste
     */
    public List<Satellit> getData(){
        return data;
    }
    /**
     * Set-Funktion zum Überschreiben der gespeicherten Satelliten-Liste
     * @param data, setzen von data
     */
    public void setData(List<Satellit> data){
        this.data = data;
    }
}
