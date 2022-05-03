/**
 * 動物陣列
 */
public class AnimalArray {
    private Animal[] animals;

    /**
     * 新增動物於陣列中
     *
     * @param animalSeries 動物種類 D:狗 C:貓 M:老鼠
     * @param animalName   動物名稱
     * @param weight       動物體重
     * @param animalCount  動物目前數量
     */
    public void addAnimals(char animalSeries, String animalName, float weight, int animalCount, int point) {
        if (animals == null) { //創建陣列
            this.animals = new Animal[1];
        }
        if (animalCount == animals.length) { //判斷是否需要擴充
            animals = doubleArr(animals);
        }
        if (point == 0) {  //創建動物
            switch (animalSeries) {
                case 'D':
                    animals[animalCount] = new Dog(animalName, weight);
                    break;
                case 'C':
                    animals[animalCount] = new Cat(animalName, weight);
                    break;
                case 'M':
                    animals[animalCount] = new Mouse(animalName, weight);
                    break;
            }
        } else if (point > 0) { //插入創建動物
            point -= 1; //陣列由0開始計算 故需-1
            //創建暫時陣列 裝數據
            Animal[] tmpArr = new Animal[animalCount];
            for (int i = 0; i < animalCount; i++) {
                tmpArr[i] = animals[i];
            }

            //裝回去成完整陣列
            for (int i = 0; i < animalCount + 1; i++) {
                if (i == point) {  //新增插入
                    switch (animalSeries) {
                        case 'D':
                            animals[i] = new Dog(animalName, weight);
                            break;
                        case 'C':
                            animals[i] = new Cat(animalName, weight);
                            break;
                        case 'M':
                            animals[i] = new Mouse(animalName, weight);
                            break;
                    }
                } else if (i > point) {  //往後退
                    animals[i] = tmpArr[i - 1];
                } else {  //保持資料
                    animals[i] = tmpArr[i];
                }
            }
        } else { //刪除動物
            //創建暫時陣列 裝數據
            Animal[] tmpArr = new Animal[animalCount];
            for (int i = 0; i < animalCount; i++) {
                tmpArr[i] = animals[i];
            }
            point *= -1; //轉回正數
            point -= 1; //陣列由0開始計算 故需-1
            //裝回去成完整陣列
            for (int i = 0; i < animalCount; i++) {
                if (i < point) {  //保持前資料
                    animals[i] = tmpArr[i];
                } else if (i > point) { //保持後資料
                    animals[i - 1] = tmpArr[i];
                }
            }
        }
    }

    /**
     * 擴充陣列空間
     *
     * @param animals 動物陣列
     * @return 回傳擴充完的陣列
     */
    public Animal[] doubleArr(Animal[] animals) {
        Animal[] newArr = new Animal[animals.length * 2];
        for (int i = 0; i < animals.length; i++) {
            newArr[i] = animals[i];
        }
        return newArr;
    }

    /**
     * 條件顯示當前動物
     *
     * @param animalCount 當前動物數量
     * @param option      顯示功能(1:全部 2:按種類 3:按體重區間 4:按姓名查找 5:指定字首字母)
     */
    public void showAnimals(int animalCount, int option, char animalSeries, float minWeight, float maxWeight, String animalName) {
        if (animalCount == 0) {
            System.out.println("無資料");
        } else {
            boolean hasSearchData = false; //判斷是否有搜尋到符合的資料
            String series = "";
            if (option == 2) { //功能為判斷種類
                switch (animalSeries) {
                    case 'D':
                        series = "Dog";
                        break;
                    case 'C':
                        series = "Cat";
                        break;
                    case 'M':
                        series = "Mouse";
                        break;
                    case 'N':
                        series = "";
                        break;
                }
            }

            //顯示動物
            for (int i = 0; i < animalCount; i++) {
                switch (option) {
                    case 1:
                        System.out.println("種類:" + animals[i].getSeries() + " 姓名:" + animals[i].getName() + " 體重:" + animals[i].getWeight());
                        hasSearchData = true;
                        break;
                    case 2:
                        if (series.equals(animals[i].getSeries())) {
                            System.out.println("種類:" + animals[i].getSeries() + " 姓名:" + animals[i].getName() + " 體重:" + animals[i].getWeight());
                            hasSearchData = true;
                        }
                        break;
                    case 3:
                        if (animals[i].getWeight() >= minWeight && animals[i].getWeight() <= maxWeight) {
                            System.out.println("體重:" + animals[i].getWeight() + " 種類:" + animals[i].getSeries() + " 姓名:" + animals[i].getName());
                            hasSearchData = true;
                        }
                        break;
                    case 4:
                        if (animalName.equals(animals[i].getName())) {
                            System.out.println("姓名:" + animals[i].getName() + " 種類:" + animals[i].getSeries() + " 體重:" + animals[i].getWeight());
                            hasSearchData = true;
                        }
                        break;
                    case 5:
                        if (animalName.charAt(0) == animals[i].getName().charAt(0)) {
                            System.out.println("姓名:" + animals[i].getName() + " 種類:" + animals[i].getSeries() + " 體重:" + animals[i].getWeight());
                            hasSearchData = true;
                        }
                        break;
                }
            }
            if (!hasSearchData) {
                System.out.println("無匹配資料");
            }
        }
    }

    /**
     * 透過名字排序顯示動物
     *
     * @param animalCount 當前動物數量
     */
    public void showAnimalsByNameCompare(int animalCount) {
        if (animalCount == 0) {
            System.out.println("無資料");
        } else {
            Animal[] showAnimals = new Animal[animalCount];
            for (int i = 0; i < animalCount; i++) { //複製出一個可排序的陣列
                showAnimals[i] = this.animals[i];
            }
            sort(new Bigger(), animalCount, showAnimals,1); //經過排序
            //顯示排序後的動物順序
            for (int i = 0; i < animalCount; i++) {
                System.out.println("姓名:" + showAnimals[i].getName() + " 種類:" + showAnimals[i].getSeries() + " 體重:" + showAnimals[i].getWeight());
            }
        }

    }

    /**
     * 透過體重排序顯示動物
     *
     * @param animalCount 當前動物數量
     */
    public void showAnimalsByWeight(int animalCount) {
        if (animalCount == 0) {
            System.out.println("無資料");
        } else {
            Animal[] showAnimals = new Animal[animalCount];
            for (int i = 0; i < animalCount; i++) { //複製出一個可排序的陣列
                showAnimals[i] = this.animals[i];
            }
            sort(new Bigger(), animalCount, showAnimals,0); //經過排序

            //顯示排序後的動物順序
            for (int i = 0; i < animalCount; i++) {
                System.out.println("體重:" + showAnimals[i].getWeight() + " 種類:" + showAnimals[i].getSeries() + " 姓名:" + showAnimals[i].getName());
            }
        }
    }

    /**
     * 泡沫排序法
     *
     * @param compare     比較器
     * @param animalCount 目前動物數量
     * @param showAnimals 排序完後的動物
     * @param option 0:透過體重 1:透過名字
     */
    public static void sort(Comparator compare, int animalCount, Animal[] showAnimals, int option) {
        for (int i = 0; i < animalCount - 1; i++) {
            for (int j = i + 1; j < animalCount; j++) {
                if(option == 0){ //透過體重排序
                    if (compare.compare(showAnimals[i].getWeight(), showAnimals[j].getWeight())) {
                        swap(showAnimals, i, j);
                    }
                }
                else if(option == 1){  //透過名字排序
                    if (showAnimals[i].getName().compareTo(showAnimals[j].getName()) > 0) {
                        swap(showAnimals, i, j);
                    }
                }
            }
        }
    }

    /**
     * 交換
     *
     * @param before 前一個數值
     * @param after  後一個數值
     */
    public static void swap(Animal[] tmpAminal, int before, int after) {
        Animal tmp = tmpAminal[before];
        tmpAminal[before] = tmpAminal[after];
        tmpAminal[after] = tmp;
    }
}