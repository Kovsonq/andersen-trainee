package multithreading;

import lombok.Data;

@Data
public class Wrapper {
    int value = 0;
    int before = 0;
    int after = 0;
    int timeBefore = 0;
    int timeAfter = 0;

    public Wrapper (){}

    public Wrapper (Wrapper wrapper) {
        this.before = wrapper.getBefore();
        this.after = wrapper.getAfter();
        this.timeBefore = wrapper.getTimeBefore();
        this.timeAfter = wrapper.getTimeAfter();
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "before=" + before +
                ", after=" + after +
                ", timeBefore=" + timeBefore +
                " ms" +
                ", timeAfter=" + timeAfter +
                " ms" +
                '}';
    }
}
