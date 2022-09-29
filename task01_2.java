

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class task01_2 {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        ArrayList<String> list = new ArrayList<>();
        FileWriter fileWriter1 = new FileWriter("Exercises.txt");
        FileWriter fileWriter2 = new FileWriter("Answers.txt");
        int a, b, c, d, e;
        while (list.size() < 300) {
            int flag = 0;
            a = r.nextInt(1, 100);
            b = r.nextInt(1, 100);
            c = r.nextInt(1, 100);
            d = r.nextInt(4);
            e = r.nextInt(2);
            if (e == 0) {
                if(d == 2 || d == 3){
                    while(a-b < 0){
                        a = r.nextInt(1, 100);
                        b = r.nextInt(1, 100);
                    }
                }
                String s = String.valueOf(a) + "," + String.valueOf(b) + "," + String.valueOf(d);
                for (String string : list) {
                    if (s.equals(string)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    list.add(s);
                }
            } else if (e == 1) {
                if(d == 1 ){
                    while(a - b - c < 0){
                        a = r.nextInt(1, 100);
                        b = r.nextInt(1, 100);
                        c = r.nextInt(1, 100);
                    }
                }else if(d ==2){
                    while(a - b + c < 0){
                        a = r.nextInt(1, 100);
                        b = r.nextInt(1, 100);
                        c = r.nextInt(1, 100);
                    }
                }else if(d == 3){
                    while(a + b - c < 0){
                        a = r.nextInt(1, 100);
                        b = r.nextInt(1, 100);
                        c = r.nextInt(1, 100);
                    }
                }
                String s = String.valueOf(a) + "," + String.valueOf(b) + "," + String.valueOf(c) + "," + String.valueOf(d);
                for (String string : list) {
                    if (s.equals(string)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    list.add(s);
                }
            }

        }
//        for (int i = 0; i < 300; i++) {
//            String s = list.get(i);
//            System.out.println(s);
//        }
        for (int i = 0; i < 300; i++) {
            String s = list.get(i);
            int x = 0;
            while (s.contains(",")) {
                s = s.substring(s.indexOf(",") + 1);
                x++;
            }
//            System.out.println(x);
            if (x == 2) {
                String[] strings = list.get(i).split(",");
                //System.out.println(s);
                int[] ints = new int[3];
                for (int j = 0; j < 3; j++) {
                    ints[j] = Integer.parseInt(strings[j]);
                }
                switch (ints[2]) {
                    case 0: {
                        fileWriter1.write(add(ints[0],ints[1]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints[0]+ints[1]));
                        fileWriter2.write("\n");
                        break;
                    }
                    case 1: {
                        fileWriter1.write(add(ints[0],ints[1]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints[0]+ints[1]));
                        fileWriter2.write("\n");
                        break;
                    }
                    case 2: {
                        fileWriter1.write(sub(ints[0],ints[1]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints[0]-ints[1]));
                        fileWriter2.write("\n");
                        break;
                    }
                    case 3: {
                        fileWriter1.write(sub(ints[0],ints[1]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints[0]-ints[1]));
                        fileWriter2.write("\n");
                        break;
                    }
                }
            } else if(x == 3){
                String[] strings = list.get(i).split(",");
                int[] ints2 = new int[4];
                for (int j = 0; j < 4; j++) {
                    ints2[j] = Integer.parseInt(strings[j]);
                }
                switch (ints2[3]) {
                    case 0: {
                        fileWriter1.write(add(ints2[0],ints2[1],ints2[2]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints2[0]+ints2[1]+ints2[2]));
                        fileWriter2.write("\n");
                        break;
                    }
                    case 1: {
                        fileWriter1.write(sub(ints2[0],ints2[1],ints2[2]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints2[0]-ints2[1]-ints2[2]));
                        fileWriter2.write("\n");
                        break;
                    }
                    case 2: {
                        fileWriter1.write(sub_2(ints2[0],ints2[1],ints2[2]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints2[0]-ints2[1]+ints2[2]));
                        fileWriter2.write("\n");
                        break;
                    }
                    case 3: {
                        fileWriter1.write(add_2(ints2[0],ints2[1],ints2[2]));
                        fileWriter1.write("\n");
                        fileWriter2.write(String.valueOf(ints2[0]+ints2[1]-ints2[2]));
                        fileWriter2.write("\n");
                        break;
                    }
                }
            }
        }
        fileWriter1.close();
        fileWriter2.close();
    }
    public static String add(int a, int b){
        String s = String.valueOf(a)+" + "+String.valueOf(b) + " = ";
        return s;
    }
    public static String add(int a, int b,int c){
        String s = String.valueOf(a)+" + "+String.valueOf(b) + " + " + String.valueOf(c)+ " = ";
        return s;
    }
    public static String sub(int a, int b){
        String s = String.valueOf(a)+" - "+String.valueOf(b) + " = ";
        return s;
    }
    public static String sub(int a, int b,int c){
        String s = String.valueOf(a)+" - "+String.valueOf(b) + " - " + String.valueOf(c)+ " = ";
        return s;
    }
    public static String sub_2(int a, int b,int c){
        String s = String.valueOf(a)+" - "+String.valueOf(b) + " + " + String.valueOf(c)+ " = ";
        return s;
    }
    public static String add_2(int a, int b,int c){
        String s = String.valueOf(a)+" + "+String.valueOf(b) + " - " + String.valueOf(c)+ " = ";
        return s;
    }

}

