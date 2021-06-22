package Model;

import java.util.List;


    public class ChannelPlus <T> extends Channel{
        private List<T> ts;
        private String sat;

        public ChannelPlus(List<T> ts) {
            this.ts = ts;
        }
        public ChannelPlus(String sat){
            this.sat = sat;
        }
    }
}
