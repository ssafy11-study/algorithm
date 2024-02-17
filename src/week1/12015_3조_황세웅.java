package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(seq[0]);
        for (int i = 1; i < n; i++) {
            int index = lowerBound(seq[i]);
            if (index == -1) {
                lis.add(seq[i]);
                continue;
            }
            lis.set(index, seq[i]);
        }

        System.out.println(lis.size());
    }

    static int lowerBound(int target) {
        int left = 0; // false
        int right = lis.size() - 1; // true
        int mid = (left + right) / 2;

        if (lis.get(right) < target) {
            return -1;
        }
        if (lis.get(left) >= target) {
            return 0;
        }

        while (left + 1 < right) {
            if (lis.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }

        return right;
    }
}
