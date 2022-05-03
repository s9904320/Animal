/**
 * 貓 繼承自動物
 */
public class Cat extends Animal {
    //創建貓
    public Cat(String name, float weight) {
        super.setName(name);
        super.setWeight(weight);
        super.setSeries("Cat");
    }
}
