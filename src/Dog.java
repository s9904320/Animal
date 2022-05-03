/**
 * 狗 繼承自動物
 */
public class Dog extends Animal {
    //創建狗
    public Dog(String name, float weight) {
        super.setName(name);
        super.setWeight(weight);
        super.setSeries("Dog");
    }
}
