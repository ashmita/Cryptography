/**
 * Created by asmita on 3/9/2016.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.util.*;
public class Playfair {
    String standard = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    char d;
    int count = 0;
    int exists = 0;
    char[][] matrix = new char[5][5];
    int h = 0;
    int k = 0;
    StringBuilder unique_text = new StringBuilder();
    String str;
    String gf = "";
    int[] indices = new int[2];
    int[] indices1 = new int[2];

    public static void main(String[] args) {
        Playfair obj1 = new Playfair();
        Scanner input = new Scanner(System.in);
        String key;
        String text;
        System.out.println("Enter the key:");
        key = input.nextLine();
        key = key.replace(" ", "");
        String X = obj1.unique_keys(key);
        System.out.println("The unique keys are: " + X);
        obj1.matrix(X);
        System.out.println("Enter the string: ");
        text = input.nextLine();
        text = text.replaceAll(" ", "");
        obj1.encryption(text);


    }
    public String unique_keys(String stri) {
        StringBuilder str=new StringBuilder(stri);
        //str = str.replace(" ", "");
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='J')
            {
                str.setCharAt(i,'I');
            }
            for (int j = 0; j < unique_text.length(); j++) {
                if (unique_text.charAt(j) == str.charAt(i)) {
                    exists = 1;
                    break;
                } else {
                    exists = 0;
                }
            }
            if (exists == 0) {
                unique_text.append(str.charAt(i));
            }
        }



        for (int i = 0; i < standard.length(); i++) {
            for (int j = 0; j < unique_text.length(); j++) {
                if (standard.charAt(i) == unique_text.charAt(j)) {
                    exists = 1;
                    break;
                } else {
                    exists = 0;
                }
            }
            if (exists == 0) {
                unique_text.append(standard.charAt(i));
            }
        }
        //return unique_text;
        str = unique_text;
        return (str.toString());

    }

    public void matrix(String u_text) {

        for (int i = 0; i < u_text.length(); i++) {

            matrix[h][k] = u_text.charAt(i);

            k++;
            if (k == 5) {
                k = 0;
                h++;
            }
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public String duplicate_filling(String message) {

        gf=message;

        for (int i = 0; i <= gf.length() - 2; i = i + 2) {
            if (gf.charAt(i) == gf.charAt(i + 1)) {
                String c1 = message.substring(0, i + 1);
                String c2 = message.substring(i + 1);
                gf = c1 + "X" + c2;
                //System.out.println("in for loop");
            }
        }


        if (gf.length() % 2 != 0) {
            gf = gf + "X";
        }
        //System.out.println(gf+"CHECK");
        //System.out.println(message + "sout in duplicate_fill");
        return gf;
    }


    public int[] find_char_index(char ch, char[][] matrix) {
        int []tempindx=new int[2];


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (ch == matrix[i][j]) {
                    tempindx[0] = i;
                    tempindx[1] = j;
                    break;

                }

            }

        }

        return tempindx;
    }


    public void encryption(String str) {
        String s = duplicate_filling(str);
        System.out.println("The message after filing " + s);
        int messageLength = s.length();
        String ciphertext = "";

        for (int i = 0; i <= messageLength - 2; i = i + 2) {
            indices = find_char_index(s.charAt(i), matrix);
            indices1 = find_char_index(s.charAt(i + 1), matrix);


            if (indices[0] == indices1[0]) {
                ciphertext = ciphertext + matrix[indices[0]][(indices[1] + 1) % 5] + matrix[indices1[0]][(indices1[1] + 1) % 5];
                //System.out.println(ciphertext);
            }
            else if (indices[1] == indices1[1]) {
                ciphertext = ciphertext + matrix[(indices[0] + 1) % 5][indices[1]] + matrix[(indices1[0] + 1) % 5][indices1[1]];
            }
            else {
                ciphertext = ciphertext + matrix[indices[0]][indices1[1]] + matrix[indices1[0]][indices[1]];
            }

        }
        System.out.println("The cipheretext will be:" + ciphertext);

    }
}



