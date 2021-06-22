package Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

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

    //Für view
    private Transponder transponder = null;
    private Satellit satellit = null;
    private String sat = null;

    public Satellit getSatellit(){return satellit};
    public Transponder getTransponder(){return transponder};
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

    public void setTransponder(Transponder transponder) {
        this.transponder = transponder;
    }

    public void setSatelit(Satellit satellit) {
        this.satellit = satellit;
    }
    public void setSat(String sat) {
        this.sat = sat;
    }

}
