package ninja.cero.fest2018.webflux.score;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @GetMapping("/{ids}")
    public List<Score> getAsList(@PathVariable List<Integer> ids) throws InterruptedException {
        Thread.sleep(100);
        return ids.stream()
                .flatMap(id -> scoreStore.get(id).stream())
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Score> getAsPost(@RequestBody Flux<Integer> ids) throws InterruptedException {
        Thread.sleep(100);
        return ids.flatMapIterable(id -> scoreStore.get(id));
    }

    static Map<Integer, List<Score>> scoreStore = new HashMap<>();

    static {
        for (int i = 1; i <= 33; i++) {
            scoreStore.put(i, create(i));
        }
    }

    static List<Score> create(int id) {
        return Arrays.asList(
                new Score(id, "国語", id + 1),
                new Score(id, "数学", id + 2),
                new Score(id, "英語", id + 3),
                new Score(id, "社会", id + 4),
                new Score(id, "理科", id + 5));
    }
}
