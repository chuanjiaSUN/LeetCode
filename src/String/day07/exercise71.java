package String.day07;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 10:24
 */
public class exercise71 {
    //栈
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        if (dirs.length == 0)
        {
            return "/";
        }
        Stack<String> stack = new Stack<>();
        for (String dir : dirs)
        {
            if ("".equals(dir) || ".".equals(dir))
            {
                continue;
            }
            if (dir.equals("..")){
                if ( !stack.isEmpty())
                {
                    stack.pop();
                }
                continue;
            }
            stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty())
        {
            sb.append("/");
        }else {
            while (!stack.isEmpty())
            {
                sb.insert(0, stack.pop());
                sb.insert(0,"/");
            }
        }
        return sb.toString();
    }
}
