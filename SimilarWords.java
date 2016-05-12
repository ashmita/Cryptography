import java.util.*;

/**
 * Created by asmita on 5/11/2016.
 */
import  java.util.ArrayList;
public class SimilarWords {
    public static ArrayList<String> Arr = new ArrayList<String>();
    public static HashSet<String> has = new HashSet<String>();


    public static void duplicateWords(String[] st1, String[] st2) {

        for (int i = 0; i < st1.length; i++) {
            for (int j = 0; j < st2.length; j++) {
                if (st1[i].equals(st2[j])) {
                    Arr.add(st1[i]);
                    break;
                }
            }
        }
        System.out.println(Arr);

    }
    public static void uniqueWords(String []st1, String []st2){
        Collections.addAll(has, st1);
        Collections.addAll(has, st2);
        System.out.println(has);

    }


    public static void main(String[] args) {
        String str1;
        String str2;
        Scanner input = new Scanner(System.in);
        System.out.println("First String:");
        str1 = input.nextLine();
        System.out.println("Second String");
        str2 = input.nextLine();
        String Arr1[] = str1.split(" ");
        String Arr2[] = str2.split(" ");
        System.out.print("Duplicate words in these strings are:");
        duplicateWords(Arr1, Arr2);
        System.out.print("Unique words of these two strings are:");
        uniqueWords(Arr1,Arr2);


    }
}



