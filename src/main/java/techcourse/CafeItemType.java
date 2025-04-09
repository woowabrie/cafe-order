package techcourse;

public enum CafeItemType {
    DRINK,
    BREAD,
    ;

    public boolean isDrink() {
        return this == DRINK;
    }
}
