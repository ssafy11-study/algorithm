import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] memory;
    static char ds[] = { 'u', 'l', 'r', 'd' };
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        memory = new int[6][N][N];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; ++j) {
                int n = Integer.parseInt(st.nextToken());
                int count = 0;
                while (n != 0) {
                    n /= 2;
                    count++;
                }
                memory[0][i][j] = count == 0 ? count : count-1;
            }
        }

        System.out.println(1 << findMax(1));
    }

    static int findMax(int idx) {
        if (idx == 6) {
            int max = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    max = Math.max(memory[5][i][j], max);
                }
            }
            return max;
        }

        int max = 0;
        for (; idx < 6; ++idx) {
            for (int i = 0; i < 4; ++i) {
                modifyMemory(memory[idx-1], memory[idx], i);
                max = Math.max(findMax(idx+1), max);
            }
        }

        return max;
    }

    static void modifyMemory(int[][] cur, int[][] next, int d) {
        switch (ds[d]) {
            case 'u': {
                for (int j = 0; j < N; ++j) {
                    int nextIndex = 0;
                    int prev = 0;
                    for (int i = 0; i < N; ++i) {
                        if (cur[i][j] == 0) continue;
                        if (prev == 0) {
                            prev = cur[i][j];
                            next[nextIndex++][j] = cur[i][j];
                        }
                        else {
                            if (prev == cur[i][j]) {
                                next[nextIndex-1][j]++;
                                prev = 0;
                            } else {
                                next[nextIndex++][j] = cur[i][j];
                                prev = cur[i][j];
                            }
                        }
                    }
                    for (; nextIndex < N; ++nextIndex) {
                        next[nextIndex][j] = 0;
                    }

                }
            }
            break;

            case 'l': {
                for (int i = 0; i < N; ++i) {
                    int nextIndex = 0;
                    int prev = 0;
                    for (int j = 0; j < N; ++j) {
                        if (cur[i][j] == 0) continue;
                        if (prev == 0) {
                            prev = cur[i][j];
                            next[i][nextIndex++] = cur[i][j];
                        }
                        else {
                            if (prev == cur[i][j]) {
                                next[i][nextIndex-1]++;
                                prev = 0;
                            } else {
                                next[i][nextIndex++] = cur[i][j];
                                prev = cur[i][j];
                            }
                        }

                    }
                    for (; nextIndex < N; ++nextIndex) {
                        next[i][nextIndex] = 0;
                    }
                }
            }
            break;

            case 'r': {
                for (int i = 0; i < N; ++i) {
                    int nextIndex = N-1;
                    int prev = 0;
                    for (int j = N-1; j >= 0; --j) {
                        if (cur[i][j] == 0) continue;
                        if (prev == 0) {
                            prev = cur[i][j];
                            next[i][nextIndex--] = cur[i][j];
                        }
                        else {
                            if (prev == cur[i][j]) {
                                next[i][nextIndex+1]++;
                                prev = 0;
                            } else {
                                next[i][nextIndex--] = cur[i][j];
                                prev = cur[i][j];
                            }
                        }
                    }
                    for (; nextIndex >= 0; --nextIndex) {
                        next[i][nextIndex] = 0;
                    }
                }
            }
            break;

            case 'd': {
                for (int j = 0; j < N; ++j) {
                    int nextIndex = N-1;
                    int prev = 0;
                    for (int i = N-1; i >= 0; --i) {
                        if (cur[i][j] == 0) continue;
                        if (prev == 0) {
                            prev = cur[i][j];
                            next[nextIndex--][j] = cur[i][j];
                        }
                        else {
                            if (prev == cur[i][j]) {
                                next[nextIndex+1][j]++;
                                prev = 0;
                            } else {
                                next[nextIndex--][j] = cur[i][j];
                                prev = cur[i][j];
                            }
                        }
                    }
                    for (; nextIndex >= 0; --nextIndex) {
                        next[nextIndex][j] = 0;
                    }
                }
            }
            break;
        }
    }
}
