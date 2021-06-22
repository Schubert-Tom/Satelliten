package Model;
import java.util.ArrayList;


public class Transponder {
    private String pol;
    private String orbital;
    private String freq;
    private String sym;
    private ArrayList<Channel> channels;

    public ArrayList<Channel> getChannels() {
        return channels;
    }
}
