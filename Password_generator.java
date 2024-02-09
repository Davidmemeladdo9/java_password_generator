import java.util.*;

public class Password_generator {

    public static void main(String[] args) {

        System.out.println("welcome to password generator ");
        int[] info = input();
        int length = info[0];
        int cap = info[1];
        int sp = info[2];

        password(length, cap, sp);
    }

    public static int[] input() {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the password you want : ");
        int length = sc.nextInt();

        while (length < 6) {
            System.out.println("A password must be minimum of 6 characters long");
            System.out.print("Enter the length of the password you want : ");
            length = sc.nextInt();
        }

        System.out.print("Enter the number of capitalised letters you want : ");
        int cap = sc.nextInt();
        while (cap > length) {
            System.out.println("The number of capitalised letters exceeds the length of your password");
            System.out.print("Enter the number of capitalised letters you want : ");
            cap = sc.nextInt();
        }

        System.out.print("Enter the number of special symbols you want : ");
        int sp = sc.nextInt();
        while (sp > length - cap) {
            System.out.println("The number of special symbols exceeds the length of your password");
            System.out.println("Enter the number of special symbols you want : ");
            sp = sc.nextInt();
        }
        sc.close();
        return new int[]{length, cap, sp};

    }

    public static void password(int length, int cap, int sp) {
        //This is the method that generates the password according to user input

        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = alphabetString.toCharArray();

        char[] special = {'!', '`', '@', '#', '$', '^', '&', '*', '_', '+', '-', '='};

        Random rand = new Random();
        String password = "";
        for (int x = 0; length > x; x++) {
            int i = rand.nextInt(26);
            char letter = alphabet[i];
            if (password.indexOf(letter) >= 0) {
                i = rand.nextInt(26);
                letter = alphabet[i];
            }
            password = password + letter;
        }
        for (int a = 0; sp > a; a++) {
            int l = rand.nextInt(password.length());
            int i = rand.nextInt(special.length);
            char boom = special[i];
            password = password.replace(password.charAt(l), boom);
        }


        for (int q = 0; cap > q; q++) {
            int i = rand.nextInt(password.length());
            char lala = password.charAt(i);
            while (!Character.isLetter(lala)) {
                i = rand.nextInt(password.length());
                lala = password.charAt(i);
            }
            char uplala = Character.toUpperCase(lala);
            password = password.replace(lala, uplala);
        }
        System.out.println(password);

    }

}