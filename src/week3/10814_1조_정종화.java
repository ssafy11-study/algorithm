// Subject: Study of Algorithm with SSAFY
// ProblemNo: 10814
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Person implements Comparable{
        int age;
        String name;
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Object o){
            Person p = (Person)o;
            return this.age - p.age;
        }
    }

	static final int MX = 10001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, x;
    static Person v[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new Person[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int _age = Integer.parseInt(st.nextToken());
            String _name = st.nextToken();
            v[i] = new Person(_age, _name);
        }
        Arrays.sort(v);
        for(int i = 0; i < N; i++) System.out.println(v[i].age + " " + v[i].name);
    }
}
