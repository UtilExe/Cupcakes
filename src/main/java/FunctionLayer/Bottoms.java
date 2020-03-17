package FunctionLayer;

import DBAccess.UserMapper;
import Objects.Bottom;

import java.util.List;

public class Bottoms {
    private static List<Bottom> bottomList;

    public static void initBottoms(){
        if (bottomList == null){
            bottomList = UserMapper.getBottom();
        }
    }

    public static List<Bottom> getBottomsList() {
        return bottomList;
    }

}
