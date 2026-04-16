import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

    // Equivalent to C++ struct Job
    static class Job {
        char id;
        int deadLine;
        int profit;

        Job(char id, int deadLine, int profit) {
            this.id       = id;
            this.deadLine = deadLine;
            this.profit   = profit;
        }
    }

    // Equivalent to C++ bool comp(Job j1, Job j2)
    static Comparator<Job> comp = (j1, j2) -> j2.profit - j1.profit;

    // Equivalent to C++ int min(int a, int b)
    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static void main(String[] args) {

        // Equivalent to C++ Job jobs[] = {{'a',2,100}, ...}
        Job jobs[] = {
            new Job('a', 2, 100),
            new Job('b', 2, 20),
            new Job('c', 1, 40),
            new Job('d', 3, 35),
            new Job('e', 1, 25)
        };

        int n = 5;

        System.out.println("Following is maximum profit sequence of Jobs: ");

        // Equivalent to C++ sort(jobs, jobs + n, comp)
        Arrays.sort(jobs, comp);

        int jobSeq[] = new int[n];   // Equivalent to int jobSeq[n]
        boolean slot[] = new boolean[n]; // Equivalent to bool slot[n]

        // Initialize all slots to false
        for (int i = 0; i < n; i++)
            slot[i] = false;

        for (int i = 0; i < n; i++) {
            for (int j = min(n, jobs[i].deadLine) - 1; j >= 0; j--) {
                if (slot[j] == false) {
                    jobSeq[j] = i;
                    slot[j]   = true;
                    break;
                }
            }
        }

        // Print the job sequence
        for (int i = 0; i < n; i++)
            if (slot[i])
                System.out.print(jobs[jobSeq[i]].id + " ");

        System.out.println();
    }
}