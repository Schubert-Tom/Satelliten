package Controller;

import Model.Data;
import Model.ViewCode;
import Model.CountCode;

/**
 * Klasse beschreibt eine allgemeine Filter und Ausgabe Struktur
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.4
 */

public class Aggregat {
    private CompleteFilter filter;
    private ViewCode view;
    private CountCode count;
    /**
     * Konstruktor für Klasse FilterForChannelAPid
     * @param filter, filter Klasse die eine Filterstruktur beschreibt
     * @param view, view Enumeration die eine Ausgabestruktur beschreibt
     * @param count, count Enumeration die angibt ob Objekte gezählt werden müssen
     * @post Instanz von Aggregat erstellt
     */
    public Aggregat(CompleteFilter filter, ViewCode view, CountCode count){
        this.filter = filter;
        this.view =  view;
        this.count = count;
    }
    /**
     * Get-Funktion für das Feld this.view
     * @return this.view
     */
    public ViewCode getView(){return this.view;}
    /**
     * Get-Funktion für das Feld this.count
     * @return this.count
     */
    public CountCode getCount(){return this.count;}
    /**
     * Funktion ruft die filter Funktion des Filters auf
     * @param data, Datenstruktur die gefiltert werden soll
     * @return this.data
     */
    public Data filter(Data data){
       return this.filter.filter(data);
    }
}
