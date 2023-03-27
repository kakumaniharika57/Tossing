import java.io.PrintWriter;
import java.util.*;

public class Toss {
    public static void main(String args[]) {
        ArrayList<ArrayList<String>> arr1 = new ArrayList<>();
        int count1 = 0, count2 = 0;
        for (int round = 1; round <= 3; round++) {
            int head1 = 0, head2 = 0;
            System.out.println("cycle" + round);
            ArrayList<String> arr = new ArrayList<>();
            arr.add("rounds");
            arr.add("player1");
            arr.add("player2");
            System.out.println(arr);
            ArrayList<String> p1;

            for (int i = 1; i <= 10; i++) {
                for (int j = i; j < i + 1; j++) {
                    p1 = new ArrayList<>();
                    p1.add("round" + "" + i);
                    if (Math.random() < 0.5)

                        p1.add("heads");
                    else
                        p1.add("Tails");
                    for (int m = i; m < i + 1; m++) {
                        if (Math.random() < 0.5)
                            p1.add("heads");
                        else {
                            p1.add("Tails");
                        }

                        arr1.add(p1);

                        if (p1.get(1).equals("heads"))
                            head1++;
                        if (p1.get(2).equals("heads"))
                            head2++;
                    }
                }
            }
            System.out.println(arr1);

            if (head1 > head2) {
                count1++;
                System.out.println("player1 wins");
            } else {
                count2++;
                System.out.println("player2 wins");
            }
        }
        System.out.println("the final winner after 3 rounds is");
        if (count1 > count2) {
            System.out.println("player1 wins");
        } else {
            System.out.println("player2 wins");
        }
        try {
            PrintWriter pw = new PrintWriter("tossing.csv");
            StringBuffer csvHeading = new StringBuffer("");
            StringBuffer csvValues = new StringBuffer("");
            csvHeading.append("Round,Player1,Player2\n");
            pw.write(csvHeading.toString());

            for (int i = 0; i < 3; i++) {
                csvValues.append("Cycle" + (i + 1) + "\n");
                for (int j = 1; j <= 10; j++) {
                    csvValues.append("Round" + j);
                    csvValues.append(",");
                    csvValues.append(arr1.get(j).get(1));
                    csvValues.append(",");
                    csvValues.append(arr1.get(j).get(2));
                    csvValues.append("\n");
                }
            }
            pw.write(csvValues.toString());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}