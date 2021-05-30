package String.day07;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 13:39
 */
public class exercise71_prac {
    public String simplifyPath(String path)
    {
        String[] dirs = path.split("/");
        if (dirs.length == 0) return "/";
        Stack<String> stack = new Stack<>();
        for (String dir : dirs)
        {
            if ( ".".equals( dir ) || "".equals(dir))
            {
                continue;
            }
            if ("..".equals(dir))
            {
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
                continue;
            }
            stack.push(dir);
        }
        StringBuffer sb = new StringBuffer();
        if (stack.isEmpty())
        {
            sb.append("/");
        }else{
            while (!stack.isEmpty())
            {
                sb.insert(0, stack.pop());
                sb.insert(0,"/");
            }
        }
        return sb.toString();
    }
}
