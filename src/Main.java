import java.util.Scanner;

public class Main {
    public static AnimalArray animalArr = new AnimalArray();
    public static int animalCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true; //判斷程式進行
        do {
            showOption();
            int option = sc.nextInt(); //使用者選項
            switch (option) {
                case 1:
                    addAnimal(0); //新增動物
                    break;
                case 2:
                    addAnimalByPoint();//新增動物於指定位置
                    break;
                case 3:
                    deleteAnimalByPoint();//刪除指定位置的動物
                    break;
                case 4:
                    showAnimalsByNameCompare();//顯示透過名字排序的動物
                    break;
                case 5:
                    showAnimalsByWeight(); //顯示透過體重排序後的動物
                    break;
                case 6:
                    showAllAnimals(); //列印出所有動物
                    break;
                case 7:
                    showAnimalsByName(); //指定名字查找動物
                    break;
                case 8:
                    showAnimalsByFirstChar();//指定開頭查找動物
                    break;
                case 9:
                    showAnimalsByWeightArea(); //列印出特定種類動物
                    break;
                case 10:
                    showAnimalsBySeries(); //列印出特定種類動物
                    break;
                case 11:
                    isContinue = false; //結束
                    break;
            }
        } while (isContinue);
    }

    /**
     * 顯示透過名字排序的動物
     */
    private static void showAnimalsByNameCompare() {
        animalArr.showAnimalsByNameCompare(animalCount);
    }

    /**
     * 刪除動物於指定位置
     */
    private static void deleteAnimalByPoint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入位置(目前長度" + animalCount + "):");
        int point = sc.nextInt();
        if (point > 0 && point <= animalCount) {
            addAnimal((point * -1));
        } else {
            System.out.println("超出範圍");
        }
    }

    /**
     * 新增動物於指定位置
     */
    private static void addAnimalByPoint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入位置(目前長度" + animalCount + "):");
        int point = sc.nextInt();
        if (point > 0 && point <= animalCount) {
            addAnimal(point);
        } else {
            System.out.println("超出範圍");
        }
    }

    /**
     * 指定字母查找動物
     */
    private static void showAnimalsByFirstChar() {
        animalArr.showAnimalsByNameCompare(animalCount);
    }

    /**
     * 指定名字查找動物
     */
    private static void showAnimalsByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入名字:");
        String animalName = sc.nextLine();

        animalArr.showAnimals(animalCount, 4, 'N', 0f, 0f, animalName);
    }

    /**
     * 依照體重區間顯示動物
     */
    private static void showAnimalsByWeightArea() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入最小體重:");
        float minWeight = sc.nextFloat();
        System.out.println("請輸入最大體重:");
        float maxWeight = sc.nextFloat();

        animalArr.showAnimals(animalCount, 3, 'N', minWeight, maxWeight, null);
    }

    /**
     * 篩選種類顯示動物
     */
    private static void showAnimalsBySeries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("篩選動物種類: D:狗 C:貓 M:老鼠");
        String animal = sc.nextLine();
        char animalChar = animal.charAt(0);
        if(animalChar=='D' || animalChar=='C' || animalChar=='M'){
            animalArr.showAnimals(animalCount, 2, animalChar, 0f, 0f, null);
        }else {
            System.out.println("不存在種類");
        }

    }

    /**
     * 透過體重排序顯示動物
     */
    private static void showAnimalsByWeight() {
        animalArr.showAnimalsByWeight(animalCount);
    }

    /**
     * 顯示目前所有動物
     */
    private static void showAllAnimals() {
        animalArr.showAnimals(animalCount, 1, 'N', 0f, 0f, null);
    }

    /**
     * 新增(刪除)動物
     */
    private static void addAnimal(int point) {
        if (point >= 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("新增動物: D:狗 C:貓 M:老鼠");
            String animal = sc.nextLine();
            char animalChar = animal.charAt(0);
            if(animalChar=='D' || animalChar=='C' || animalChar=='M'){
                System.out.println("請輸入動物名稱:");
                String animalName = sc.nextLine();
                System.out.println("請輸入動物體重:");
                float animalWeight = sc.nextFloat();

                animalArr.addAnimals(animalChar, animalName, animalWeight, animalCount, point); //新增動物

                animalCount++; //目前動物數量+1

            }
            else {
                System.out.println("不存在的種類");
            }
        } else {
            animalArr.addAnimals('N', "", 0f, animalCount, point); //新增動物

            animalCount--; //目前動物數量-1
        }
    }

    /**
     * 顯示使用者介面
     */
    private static void showOption() {
        System.out.println("請選擇功能:");
        System.out.println("1.新增動物");
        System.out.println("2.插入一個動物(指定位置)");
        System.out.println("3.刪除一個動物(指定位置)");
        System.out.println("4.照名字排序動物");
        System.out.println("5.照體重排序動物");
        System.out.println("6.列印出所有動物");
        System.out.println("7.指定名字查找動物");
        System.out.println("8.指定名字開頭字母查找動物");
        System.out.println("9.依體重區間篩選動物");
        System.out.println("10.依種類篩選動物");
        System.out.println("11.結束");
    }
}
