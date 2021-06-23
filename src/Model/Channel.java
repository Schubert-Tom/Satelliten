package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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

    public Channel() {
    }

    public Channel (String sid){
        this.sid= sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setA_pid(String a_pid) {
        this.a_pid = a_pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setV_pid(String v_pid) {
        this.v_pid = v_pid;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEnc(String enc) {
        this.enc = enc;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public void setRes(String res) {
        this.res = res;
    }


    public String getSid() {
        return sid;
    }

    public String getType() {
        return type;
    }

    public String getA_pid() {
        return a_pid;
    }

    public String getName() {
        return name;
    }

    public String getV_pid() {
        return v_pid;
    }

    public String getCompression() {
        return compression;
    }

    public String getUrl() {
        return url;
    }

    public String getEnc() {
        return enc;
    }

    public String getPack() {
        return pack;
    }

    public String getRes() {
        return res;
    }

    public Transponder getTransponder() {
        return transponder;
    }

    public void setTransponder(Transponder transponder) {
        this.transponder = transponder;
    }

    public Satellit getSatellit() {
        return satellit;
    }

    public void setSatellit(Satellit satellit) {
        this.satellit = satellit;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
