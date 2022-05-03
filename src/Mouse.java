/**
 * 老鼠 繼承自動物
 */
public class Mouse extends Animal {
    //創建老鼠
    public Mouse(String name, float weight) {
        super.setName(name);
        super.setWeight(weight);
        super.setSeries("Mouse");
    }
}
