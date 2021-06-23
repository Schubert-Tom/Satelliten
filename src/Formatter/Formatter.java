package Formatter;

import Model.Channel;
import Model.Satellit;


import java.util.ArrayList;
import java.util.List;

public abstract class Formatter {
   // char front =' ';
    protected char back = ' ';
    protected int place =-1;
    protected List<Satellit> satellits;
    public List<?> format(char back, int place, List<?> list){


        return list;
    }
    public List<Channel> getAllChannels(){
        List<Channel>channels = new ArrayList<Channel>();
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                channels.addAll(transponder.getChannels());
            });
        });
        return channels;
    }
}
