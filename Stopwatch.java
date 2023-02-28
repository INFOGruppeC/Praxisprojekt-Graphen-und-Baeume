import java.time.Duration;
import java.time.Instant;

// Eine Klasse geschrieben und geliebt von @Lukas

public class Stopwatch {
    private Instant start;
    private Instant end;

    public Stopwatch() {
        start = Instant.now();
        end = Instant.now();
    }

    public void start() {
        start = Instant.now();
    }

    public void stop() {
        end = Instant.now();
    }

    public Duration time() {
        return Duration.between(start, end);
    }

}