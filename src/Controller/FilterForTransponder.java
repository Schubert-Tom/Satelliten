package Controller;

import Model.Transponder;
import java.util.List;

public interface FilterForTransponder {
    List<Transponder> filter(List<Transponder> transponderList);
}

