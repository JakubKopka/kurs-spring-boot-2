package pl.kopka.kursspringboot2.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeAspect {

    private long startTime;
    private long stopTime;

    @Before(value = "@annotation(StartAnnotation)")
    private void start() {
        this.startTime = System.currentTimeMillis();
    }

    @After(value = "@annotation(StopAnnotation)")
    private void stop() {
        this.stopTime = System.currentTimeMillis();
        float elapsedTimeSec = (this.stopTime-this.startTime)/1000F;
        System.out.print(" time: " + elapsedTimeSec);
    }
}
