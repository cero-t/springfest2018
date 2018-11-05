package ninja.cero.fest2018.webflux.student;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAsFlux() {
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> students[i.intValue()])
                .take(students.length);
    }

    @GetMapping(value = "/list")
    public List<Student> getAsList() throws InterruptedException {
        Thread.sleep(students.length * 100L);
        return Arrays.asList(students);
    }

    Student[] students = {
            new Student(1, "武藤"),
            new Student(2, "三吉"),
            new Student(3, "松井"),
            new Student(4, "中元"),
            new Student(5, "飯田"),
            new Student(6, "堀内"),
            new Student(7, "杉﨑"),
            new Student(8, "佐藤"),
            new Student(9, "水野"),
            new Student(10, "菊地"),
            new Student(11, "野津"),
            new Student(12, "田口"),
            new Student(13, "大賀"),
            new Student(14, "杉本"),
            new Student(15, "白井"),
            new Student(16, "磯野"),
            new Student(17, "黒澤"),
            new Student(18, "倉島"),
            new Student(19, "岡田"),
            new Student(20, "山出"),
            new Student(21, "岡崎"),
            new Student(22, "新谷"),
            new Student(23, "麻生"),
            new Student(24, "日髙"),
            new Student(25, "吉田"),
            new Student(26, "藤平"),
            new Student(27, "有友"),
            new Student(28, "森"),
            new Student(29, "白鳥"),
            new Student(30, "野中"),
            new Student(31, "田中"),
            new Student(32, "八木"),
            new Student(33, "野崎"),
    };
}
