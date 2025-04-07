package techcourse;

import java.util.List;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public Item itemFrom(String item) {
        for (Item cafeItem : items) {
            if (cafeItem.isSameName(item)) {
                return cafeItem;
            }
        }
        throw new IllegalArgumentException("없는 메뉴입니다.");
    }
}
