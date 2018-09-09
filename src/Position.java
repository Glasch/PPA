/*
 * Author: glaschenko
 * Created: 06.09.2018
 */
public enum Position {
    EARLY_POSITION("EarlyPosition"),
    MIDDLE_POSITION("MiddlePosition"),
    CUTOFF("Cutoff"),
    BUTTON("Button"),
    SB("SmallBlind"),
    BB("BigBlind");

    private String tag;

    Position(String tag) {
        this.tag = tag;
    }

    public static Position getByTag(String tag){
        for (Position position : values()) {
            if(position.tag.equals(tag)){
                return position;
            }
        }
        return null;
    }


}
