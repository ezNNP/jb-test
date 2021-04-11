package ru.stray27;

import java.util.concurrent.*;
import java.util.regex.Pattern;

public class ConcurrentStringMatcher {

    private static final long TIMEOUT = 1L;
    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    public static boolean matches(String text, String regex) {
        return matches(text, regex, TIMEOUT, TIME_UNIT);
    }

    public static boolean matches(String text, String regex, long timeout, TimeUnit timeUnit) {
        FutureTask<Boolean> matchesTask = new FutureTask<>(() -> Pattern.compile(regex).matcher(text).matches());
        Thread matchesThread = new Thread(matchesTask);
        matchesThread.start();
        try {
            return matchesTask.get(timeout, timeUnit);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            matchesTask.cancel(true);
            e.printStackTrace();
            return false;
        }
    }

}
