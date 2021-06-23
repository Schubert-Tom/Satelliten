package Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Klasse zum Speichern eines einzelnen Kanals
 * @author 4328112, 1319658, 1060449
 * @version 2.1
 */
@JsonInclude(Include.NON_NULL)
public class Channel {
    private String sid;
    private String type;
    private String a_pid;
    private String name;
    private String v_pid;
    private String compression;
    private String url;
    private String enc;
    @JsonProperty("package")
    private String pack;
    private String res;

    //Für View
    private Transponder transponder = null;
    private Satellit satellit = null;
    private String sat = null;
    private Integer count = null;
    /**
     * default Konstruktor eines Kanals
     */
    public Channel() {
    }

    /**
     * Set-Funktion zum Überschreiben der SID
     * @param sid, setzen von sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }
    /**
     * Set-Funktion zum Überschreiben des types
     * @param type, setzen von type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Set-Funktion zum Überschreiben der a_pid
     * @param a_pid, setzen von a_pid
     */
    public void setA_pid(String a_pid) {
        this.a_pid = a_pid;
    }
    /**
     * Set-Funktion zum Überschreiben von name
     * @param name, setzen von name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Set-Funktion zum Überschreiben der v_pid
     * @param v_pid, setzen von v_pid
     */
    public void setV_pid(String v_pid) {
        this.v_pid = v_pid;
    }
    /**
     * Set-Funktion zum Überschreiben der compression
     * @param compression, setzen von compression
     */
    public void setCompression(String compression) {
        this.compression = compression;
    }
    /**
     * Set-Funktion zum Überschreiben der url
     * @param url, setzen von url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Set-Funktion zum Überschreiben des enc
     * @param enc, setzen von enc
     */
    public void setEnc(String enc) {
        this.enc = enc;
    }
    /**
     * Set-Funktion zum Überschreiben des packs
     * @param pack, setzen von pack
     */
    public void setPack(String pack) {
        this.pack = pack;
    }
    /**
     * Set-Funktion zum Überschreiben der res
     * @param res, setzen von res
     */
    public void setRes(String res) {
        this.res = res;
    }

    /**
     * Get-Funktion zum Laden des sid Feldes
     * @return channels, aktuell gespeichertes sid Feldes
     */
    public String getSid() {
        return sid;
    }
    /**
     * Get-Funktion zum Laden des type Feldes
     * @return channels, aktuell gespeichertes type Feldes
     */
    public String getType() {
        return type;
    }
    /**
     * Get-Funktion zum Laden des a_pid Feldes
     * @return channels, aktuell gespeichertes a_pid Feldes
     */
    public String getA_pid() {
        return a_pid;
    }
    /**
     * Get-Funktion zum Laden des name Feldes
     * @return channels, aktuell gespeichertes name Feldes
     */
    public String getName() {
        return name;
    }
    /**
     * Get-Funktion zum Laden des sid Feldes
     * @return channels, aktuell gespeichertes sid Feldes
     */
    public String getV_pid() {
        return v_pid;
    }
    /**
     * Get-Funktion zum Laden des compression Feldes
     * @return channels, aktuell gespeichertes compression Feldes
     */
    public String getCompression() {
        return compression;
    }
    /**
     * Get-Funktion zum Laden des url Feldes
     * @return channels, aktuell gespeichertes url Feldes
     */
    public String getUrl() {
        return url;
    }
    /**
     * Get-Funktion zum Laden des enc Feldes
     * @return channels, aktuell gespeichertes enc Feldes
     */
    public String getEnc() {
        return enc;
    }
    /**
     * Get-Funktion zum Laden des pack Feldes
     * @return channels, aktuell gespeichertes pack Feldes
     */
    public String getPack() {
        return pack;
    }
    /**
     * Get-Funktion zum Laden des res Feldes
     * @return channels, aktuell gespeichertes res Feldes
     */
    public String getRes() {
        return res;
    }
    /**
     * Get-Funktion zum Laden des transponder Feldes
     * @return channels, aktuell gespeichertes transponder Feldes
     */
    public Transponder getTransponder() {
        return transponder;
    }

    /**
     * Set-Funktion zum Überschreiben des transponders
     * @param transponder, setzen von transponder
     */
    public void setTransponder(Transponder transponder) {
        this.transponder = transponder;
    }
    /**
     * Get-Funktion zum Laden des satellit Feldes
     * @return channels, aktuell gespeichertes satellit Feldes
     */
    public Satellit getSatellit() {
        return satellit;
    }
    /**
     * Set-Funktion zum Überschreiben des satellits
     * @param satellit, setzen von satellit
     */
    public void setSatellit(Satellit satellit) {
        this.satellit = satellit;
    }
    /**
     * Get-Funktion zum Laden des sat Feldes
     * @return channels, aktuell gespeichertes sat Feldes
     */
    public String getSat() {
        return sat;
    }
    /**
     * Set-Funktion zum Überschreiben des sats
     * @param sat, setzen von sat
     */
    public void setSat(String sat) {
        this.sat = sat;
    }
    /**
     * Get-Funktion zum Laden des count Feldes
     * @return channels, aktuell gespeichertes count Feldes
     */
    public Integer getCount() {
        return count;
    }
    /**
     * Set-Funktion zum Überschreiben des counts
     * @param count, setzen von count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}
