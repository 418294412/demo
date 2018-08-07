import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class shuchuan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        while (scanner.hasNextInt()){
            N=scanner.nextInt();
            ArrayList<String> list=new ArrayList<String>();
            for(int i=0;i<N;i++)
                list.add(String.valueOf(scanner.nextInt()));
            Collections.sort(list);
            StringBuilder sb=new StringBuilder();
            for(int i=N-1;i>=0;i--)
                sb.append(list.get(i));
            System.out.println(sb.toString());
        }
    }
}
