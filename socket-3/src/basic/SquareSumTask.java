package basic;


public class SquareSumTask implements Runnable {
    private int start;
    private int end;
    private String taskName;

    public SquareSumTask(int start, int end, String taskName) {
        this.start = start;
        this.end = end;
        this.taskName = taskName;
    }

    public void run() {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i * i;
        }
        System.out.println(taskName + " - Square sum from " + start + " to " + end + " is " + sum);
    }
}
