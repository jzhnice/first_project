/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-06-30 11:20
 */
public class User {
    public static double money;

    public static void searchMoney() {
        String moneys = Double.toString(money);
        String nums = moneys.substring(0, moneys.indexOf("."));
        String end = moneys.substring(moneys.indexOf("."));
        StringBuffer str = new StringBuffer(nums);


        for (int i = str.length() - 3; i > 0; i = i - 3) {
            str.insert(i, ',');
        }
        System.out.println("你的余额为" + money);
    }
}