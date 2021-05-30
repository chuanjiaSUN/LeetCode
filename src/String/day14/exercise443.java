package String.day14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-11 12:57
 */
public class exercise443 {
    public int compress(char[] chars) {
      int anchor = 0, write = 0;
      for (int read = 0; read < chars.length; read++)
      {
          if (read + 1 == chars.length || chars[read + 1] != chars[read])
          {
              chars[write++] = chars[anchor];
              if (read > anchor)
              {
                  for (char c : ("" + (read - anchor + 1)).toCharArray())
                  {
                      chars[write++] = c;
                  }
              }
              anchor = read + 1;
          }
      }
      return write;
    }
    public int compress1(char[] chars)
    {
        int cur = 0, write = 0;
        for (int read = 0; read < chars.length; read++)
        {
            if (read + 1 == chars.length || chars[read + 1] != chars[read])
            {
                chars[write++] = chars[cur];
                if (read > cur)
                {
                    for (char c : ("" + (read - cur + 1)).toCharArray())
                    {
                        chars[write++] = c;
                    }
                }
                cur = read + 1;
            }
        }
        return write;
    }
}
