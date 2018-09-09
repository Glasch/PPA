import org.json.JSONObject;

/**
 * Copyright (c) Anton on 30.08.2018.
 */
public class Hand {
    String line;
    Integer gameNumber;
    Position position;
    String holeCards;
    Integer wonLossInBBs;
    String preflopAction;
    String preflopFacing;
    String dateTime;
    Integer wonLossInCents;

    public Hand(JSONObject jsonObject) {
        this.line = jsonObject.getString("Line");
        this.gameNumber = jsonObject.getInt("GameNumber");
        String posTag = jsonObject.getString("Position");
        this.position = Position.getByTag(posTag);
        this.holeCards = jsonObject.getString("HoleCards");
        this.wonLossInBBs = jsonObject.getInt("WonLossInBBs");
        this.preflopAction = jsonObject.getString("PreflopAction");
        this.preflopFacing = jsonObject.getString("PreflopFacing");
        this.dateTime = jsonObject.getString("DateTime");
        this.wonLossInCents = jsonObject.getInt("WonLossInCents");
    }
}
