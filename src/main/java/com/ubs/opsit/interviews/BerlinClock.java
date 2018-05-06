package com.ubs.opsit.interviews;

/**
 * Created by mayankgupta on 06/05/18.
 */

class BerlinClock implements TimeConverter {

    private static final int MAX_LIGHT_ROW1 = 4;
    private static final int MAX_LIGHT_ROW2 = MAX_LIGHT_ROW1;
    private static final int MAX_LIGHT_ROW3 = 11;
    private static final int MAX_LIGHT_ROW4 = MAX_LIGHT_ROW1;
    private static final int TIME_ELAPSED = 5;

    @Override
    public String convertTime(String aTime) {

        return convertTopLight(getSeconds(aTime)).concat("\n")
                .concat(convertFiveHourRow(getHours(aTime))).concat("\n")
                .concat(convertOneHourRow(getHours(aTime))).concat("\n")
                .concat(convertFiftyFiveMinutesRow(getMinutes(aTime))).concat("\n")
                        .concat(convertForMinuteRow(getMinutes(aTime)));

    }

    private String convertTopLight(int seconds) {
        return seconds % 2 == 0 ? "Y" : "O";
    }

    private String convertFiveHourRow(int hours) {
        int onLight = hours / TIME_ELAPSED;
        int offLight = MAX_LIGHT_ROW1 - onLight;
        return createLightSeq(onLight, "R").concat(createLightSeq(offLight, "O"));
    }

    private String convertOneHourRow(int hours) {
        int onLight = hours % TIME_ELAPSED;
        int offLight = MAX_LIGHT_ROW2 - onLight;
        return createLightSeq(onLight, "R").concat(createLightSeq(offLight, "O"));
    }

    private String convertFiftyFiveMinutesRow(int minutes) {
        int onLight = minutes / TIME_ELAPSED;
        int offLight = MAX_LIGHT_ROW3 - onLight;
        return setQuaterLight(createLightSeq(onLight, "Y").concat(createLightSeq(offLight, "O")));
    }

    private String convertForMinuteRow(int minutes) {
        int onLight = minutes % TIME_ELAPSED;
        int offLight = MAX_LIGHT_ROW4 - onLight;
        return createLightSeq(onLight, "Y").concat(createLightSeq(offLight, "O"));
    }

    private String setQuaterLight(String sequence) {

        final StringBuilder time = new StringBuilder(sequence);

        for (int i = 2; i < sequence.length(); i = i + 3) {
            if(time.charAt(i)=='Y')
            time.setCharAt(i, 'R');
        }
        return time.toString();
    }

    private String createLightSeq(int nosOfLight, String light) {

        String sequence = "";
        for (int i = 0; i < nosOfLight; i++) {
            sequence = sequence.concat(light);
        }
        return sequence;

    }

    private int getHours(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    private int getMinutes(String time) {
        return Integer.parseInt(time.split(":")[1]);
    }

    private int getSeconds(String time) {
        return Integer.parseInt(time.split(":")[2]);
    }
}
