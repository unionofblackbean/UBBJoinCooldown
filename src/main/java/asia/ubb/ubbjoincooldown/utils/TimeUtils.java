package asia.ubb.ubbjoincooldown.utils;

public class TimeUtils {

    private TimeUtils() {
    }

    public static long parseSecond(String from) {
        StringBuilder tmp = new StringBuilder();
        long ticks = 0;

        for (char c : from.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp.append(c);
            } else {
                long charInLong = Long.parseLong(tmp.toString().trim());
                switch (c) {
                    case 'y':
                        ticks += charInLong * 31556952;
                        break;

                    case 'M':
                        ticks += charInLong * 2629746;
                        break;

                    case 'd':
                        ticks += charInLong * 86400;
                        break;

                    case 'h':
                        ticks += charInLong * 3600;
                        break;

                    case 'm':
                        ticks += charInLong * 60;
                        break;

                    case 's':
                        ticks += charInLong;
                        break;

                    default:
                        break;
                }
                tmp.setLength(0);
            }
        }

        return ticks;
    }

}