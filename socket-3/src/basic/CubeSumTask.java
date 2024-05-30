package basic;


public class CubeSumTask implements Runnable {
    private int start;
    private int end;
    private String taskName;

    public CubeSumTask(int start, int end, String taskName) {
        this.start = start;
        this.end = end;
        this.taskName = taskName;
    }

    public void run() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i * i * i;
        }
        System.out.println(taskName + " - Cube sum from " + start + " to " + end + " is " + sum);
    }
}

