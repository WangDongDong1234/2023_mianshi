package chapter56;

import java.util.HashSet;
import java.util.Set;

/**
 * 处理过程中需要的二维数组的元素定义（二维数组的单元格）
 */
public class ArrayElement {

    private int value;

    private Set<Element> elements;

    public ArrayElement(int value, Element elements) {
        this.value = value;
        this.elements = new HashSet<>();
        this.elements.add(elements);
    }

    public ArrayElement(int value, Set<Element> elements) {
        this.value = value;
        this.elements = elements;
    }

    public ArrayElement() {
        this.value = value;
        this.elements = new HashSet<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }
}
