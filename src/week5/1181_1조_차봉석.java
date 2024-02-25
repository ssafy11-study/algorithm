import java.io.*;
import java.util.*;

class Main {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        // 입력받기
        String[] arr = new String[N];
        while(N-- > 0) {
            String target = sc.next();
            arr[cnt++] = target;
        }

        // 정렬하기
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        // 출력하기
        System.out.println(arr[0]);
        for (int i=1; i<arr.length; i++) {
            if (arr[i].equals(arr[i-1])) continue;
            System.out.println(arr[i]);
        }
    }
}