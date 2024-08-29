import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Student implements Comparable<Student>  {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}


class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        List<Student> students = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);

            students.add(new Student(name,score));
        }

        Collections.sort(students);

        for (int j = 0; j < n ; j++) {
            System.out.print(students.get(j).getName() + " ");   
        }
    }
}