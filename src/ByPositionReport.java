import java.util.ArrayList;

/**
 * Copyright (c) Anton on 30.08.2018.
 */
public class ByPositionReport {
    private ArrayList<Hand> hands;

    private Integer utgHands = 0;
    private Integer utgWin = 0;

    private Integer mpHands = 0;
    private Integer coHands = 0;
    private Integer btnHands = 0;
    private Integer sbHands = 0;

    private Integer bbHands = 0;
    private Integer bbwin = 0;


    ByPositionReport(ArrayList<Hand> hands) {
        this.hands = hands;
    }

    void createReport() {
        for (Hand hand1 : hands) {
            switch (hand1.position) {
                case EARLY_POSITION:
                    utgHands++;
                    utgWin += hand1.wonLossInCents;
                    break;
                case MIDDLE_POSITION:
                    mpHands++;
                    break;
                case CUTOFF:
                    coHands++;
                    break;
                case BUTTON:
                    btnHands++;
                    break;
                case SB:
                    sbHands++;
                    break;
                case BB:
                    bbHands++;
                    bbwin += hand1.wonLossInCents;
                    break;
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
