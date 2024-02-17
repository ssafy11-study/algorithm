import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] persons = new Person[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			persons[i] = new Person();
			persons[i].age = Integer.parseInt(st.nextToken());
			persons[i].name = st.nextToken();
		}
		Arrays.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}
		});
			
		
		for(int i = 0; i < N; i++) {
			System.out.println(persons[i].age +" "+ persons[i].name);
		}
	}

	public static class Person {
		int age;
		String name;

		public Person() {
		}

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		public String toString() {
			return age+" "+name;
		}
	}

}