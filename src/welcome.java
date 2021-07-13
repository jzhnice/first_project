/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-06-28 12:11
 */
import java.util.Scanner;
public class welcome {
    public static void main(String[] args) {
        String user = "zhan";
        String pwd = "123";
        System.out.println("**********************************");
        System.out.println("\t欢迎登陆前程ATM系统");
        System.out.println("**********************************");
        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        boolean flag = false; // 是否登陆成功 默认为失败
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
                        User.searchMoney();
                        break;
                    case 2:
                        System.out.println("请输入存款金额");
                        float saveMoney = input.nextFloat();
                        if (saveMoney > 10000) {
                            System.out.println("单次最大存款金额为1000元");
                            saveMoney = 0;
                        } else if (saveMoney < 0) {
                            System.out.println("不能存负数的钱");
                            saveMoney = 0;
                        } else if (saveMoney % 100 != 0) {
                            System.out.println("不能存零钱");
                            saveMoney = 0;
                        } else {
                            User.money = User.money + saveMoney;
                            System.out.println("存款成功");
                            for (int i = 0; i < changeMoney.length; i++) {
                                if (changeMoney[i] == null) {
                                    changeMoney[i] = "存" + saveMoney;
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("请输入取款金额");
                        float getMoney = input.nextFloat();
                        if (getMoney > 10000) {
                            System.out.println("单次最大取款金额为1000元");
                            getMoney = 0;
                        } else if (getMoney < 0) {
                            System.out.println("不能取负数的钱");
                            getMoney = 0;
                        } else if (getMoney % 100 != 0) {
                            System.out.println("不能取零钱");
                            getMoney = 0;
                        } else if (User.money < getMoney) {
                            System.out.println("余额不足");
                            getMoney = 0;
                        } else {
                            User.money = User.money-getMoney;
                            System.out.println("取款成功");
                            for (int i = 0; i < changeMoney.length; i++) {
                                if (changeMoney[i] == null) {
                                    changeMoney[i] = "取" + getMoney;
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("交易信息");
                        for (int i = 0; i < changeMoney.length; i++) {
                            if (changeMoney[i] != null) {
                                System.out.println(changeMoney[i] + " ");
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