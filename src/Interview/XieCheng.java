package Interview;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-24 16:25
 */
public class XieCheng {

    private static volatile XieCheng test;

    public static XieCheng getInstance(){
        if (test == null){
            synchronized (XieCheng.class){
//                if (test == null){
                    test = new XieCheng();
//                }
            }
        }
        return test;
    }


    public static void main(String[] args) throws InterruptedException {

        XieCheng instance1 = XieCheng.getInstance();



    }

}
