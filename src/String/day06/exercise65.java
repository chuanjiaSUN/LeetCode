package String.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-24 14:58
 */
public class exercise65 {



    public boolean isNumber(String s) {
        Map<State, Map<charType,State>> transfer = new HashMap<>();
        Map<charType, State> intialMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_INTNUMBER);
            put(charType.CHAR_POINT, State.STATE_POINT_WITHOUT_NUM);
            put(charType.CHAR_SIGN,State.STATE_INTIAL_SIGN);
        }};
        transfer.put(State.STATE_INTIAL, intialMap);

        Map<charType, State> intSignMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_INTNUMBER);
            put(charType.CHAR_POINT, State.STATE_POINT_WITHOUT_NUM);
        }};
        transfer.put(State.STATE_INTIAL_SIGN, intSignMap);

        Map<charType, State> integerMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_EXP, State.STATE_EXP);
            put(charType.CHAR_NUM, State.STATE_INTNUMBER);
            put(charType.CHAR_POINT, State.STATE_POINT);
        }};
        transfer.put(State.STATE_INTNUMBER,integerMap);

        Map<charType, State> pointMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_FRACTION);
            put(charType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_POINT, pointMap);

        Map<charType, State> pointWithOutIntMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_NUM, pointWithOutIntMap);

        Map<charType, State> fractionMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_FRACTION);
            put(charType.CHAR_EXP, State.STATE_EXP);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);

        Map<charType, State> expMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_EXP_NUM);
            put(charType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        Map<charType, State> expSignMap = new HashMap<charType, State>()
        {{
            put(charType.CHAR_NUM, State.STATE_EXP_NUM);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        Map<charType, State> expNum = new HashMap<charType, State>()
        {
            {
                put(charType.CHAR_NUM, State.STATE_EXP_NUM);
            }
        };
        transfer.put(State.STATE_EXP_NUM, expNum);

        int length = s.length();
        State state = State.STATE_INTIAL;
        for (int i = 0; i < length; i++)
        {
            charType type = charToType(s.charAt(i));
            if (!transfer.get(state).containsKey(type))
            {
                return false;
            }else{
                state = transfer.get(state).get(type);
            }
        }

        return state == State.STATE_INTNUMBER
                || state == State.STATE_POINT
                || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUM
                || state == State.STATE_END;

    }

    private charType charToType(char c) {
        if (c >= '0' && c <= '9')
        {
            return charType.CHAR_NUM;
        }else if(c == '.')
        {
            return charType.CHAR_POINT;
        }else if( c == 'e' || c == 'E')
        {
            return charType.CHAR_EXP;
        }else if( c == '-' || c == '+')
        {
            return charType.CHAR_SIGN;
        }else{
            return charType.CHAR_ILLEGAL;
        }
    }

    public static void main(String[] args) {
        exercise65 e = new exercise65();
        boolean number = e.isNumber("-inf");
        System.out.println(number);
    }
    enum State{
        STATE_INTIAL,
        STATE_INTIAL_SIGN,
        STATE_INTNUMBER,
        STATE_POINT,
        STATE_POINT_WITHOUT_NUM,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUM,
        STATE_END,
    }

    enum charType{
        CHAR_NUM,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_ILLEGAL,
    }
}




