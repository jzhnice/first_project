import java.util.Scanner;
/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-07-13 08:49
 */
public class test {
    public static void main(String[] args) {
        String user = "zhan";
        String pwd = "123";
        System.out.println("**********************************");
        System.out.println("\t欢迎登陆前程ATM系统");
        System.out.println("**********************************");
        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        boolean flag = false; // 是否登陆成功 默认为失败
        double yue = 0;   //初始值
        for (int i = 3; i > 0; i--) {
            System.out.println("请输入用户名");
            String checkUser = input.next();
            System.out.println("请输入密码");
            String checkPwd = input.next();
            if (user.equals(checkUser) && pwd.equals(checkPwd)) {
                System.out.println("登陆成功");
                flag = true;
                break;
            } else {
                if (i == 1) {
                    System.out.println("你的卡被吞了！请找工作人员");
                } else {

                    System.out.println("用户名或密码错误！今日剩余次数为：" + (i - 1));
                }
            }
        }
        if (flag) {
            int choice = 0;
            String[] changeMoney = new String[50];
            do {
                System.out.println("**********************************************");
                System.out.println("\t1、查询 \n\t2、存款 \n\t3、取款 \n\t4、交易信息\n\t5、退出");
                System.out.println("*******************************");
                System.out.println("请选择你要执行的操作");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("您的余额为：" + yue);
                        break;
                    case 2:
                        System.out.println("请输入存款金额");
                        float cunkuan = input.nextInt();
                        if (cunkuan > 10000) {
                            System.out.println("单次最大存款为10000");
                            cunkuan = 0;
                        } else if (cunkuan % 100 != 0) {
                            System.out.println("不能存零钱");
                            cunkuan = 0;
                        } else if (cunkuan < 0) {
                            System.out.println("不能存负数的钱");
                        } else {
                            yue = (yue + cunkuan);
                            System.out.println("存款成功");
                            for (int i = 0; i < changeMoney.length; i++) {
                                if (changeMoney[i] == null) {
                                    changeMoney[i] = "存" + cunkuan;
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("请输入取款金额");
                        float qukuan = input.nextFloat();
                        if (qukuan > 10000) {
                            System.out.println("不能一次性取这麽多钱");
                        } else if (qukuan > yue) {
                            System.out.println("余额不足");
                        } else if (qukuan < 0) {
                            System.out.println("不能取负数的钱");
                        } else {
                            yue = yue - qukuan;
                            System.out.println("取款成功");
                            for (int i = 0; i < changeMoney.length; i++) {
                                if (changeMoney[i] == null) {
                                    changeMoney[i] = "取" + qukuan;
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("交易信息");
                        for (int i = 0; i < changeMoney.length; i++) {
                            if (changeMoney[i] != null) {
                                System.out.println(changeMoney[i] + "");
                            }
                        }
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("退出系统");
                        break;
                }
            } while (choice != 5);
        }
    }
}
