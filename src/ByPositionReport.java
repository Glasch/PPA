import java.util.ArrayList;

/**
 * Copyright (c) Anton on 30.08.2018.
 */
public class ByPositionReport {
    ArrayList <Hand> hands = new ArrayList <>();
    String position;
    Integer utgHands = 0;
    Integer utgWin = 0;

    Integer mpHands = 0;
    Integer coHands = 0;
    Integer btnHands = 0;
    Integer sbHands = 0;

    Integer bbHands = 0;
    Integer bbwin = 0;

    public ByPositionReport(ArrayList <Hand> hands) {
        this.hands = hands;
    }

    void createReport() {
        for (Hand hand1 : hands) {
            if (hand1.position.equals("EarlyPosition")) {
                utgHands++;
                if (hand1.wonLossInCents < 0) {
                    utgWin -= hand1.wonLossInBBs;
                }else{
                    utgWin+=hand1.wonLossInBBs;
                }
            }
            if (hand1.position.equals("MiddlePosition")) {
                mpHands++;
            }
            if (hand1.position.equals("Cutoff")) {
                coHands++;
            }
            if (hand1.position.equals("Button")) {
                btnHands++;
            }
            if (hand1.position.equals("SmallBlind")) {
                sbHands++;
            }
            if (hand1.position.equals("BigBlind")) {
                bbHands++;
                if (hand1.wonLossInCents < 0) {
                    bbwin -= hand1.wonLossInBBs;
                }else{
                    bbwin += hand1.wonLossInBBs;
                }
            }

        }
        System.out.println("utg count = " + utgHands + " won = " + utgWin);
        System.out.println("mp count = " + mpHands);
        System.out.println("co count = " + coHands);
        System.out.println("btn count = " + btnHands);
        System.out.println("sb count = " + sbHands);
        System.out.println("bb count = " + bbHands + " won = " + bbwin);

    }

}
