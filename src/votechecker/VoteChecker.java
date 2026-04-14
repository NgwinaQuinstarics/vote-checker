import java.util.Scanner;

public class VoteChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(" VOTE CHECKER APP ");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.println("\n RESULT ");

        if (age >= 18) {
            System.out.println(name + ", you are eligible to vote ✅");
        } else {
            System.out.println(name + ", you are NOT eligible to vote ❌");
        }

        System.out.println("\nVote Checker finished.");
    }
}