package net.epnmag9.lib;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class InteractiveCLILib {
    public static <E> E chooseFrom(Scanner scn,PrintStream ps,Iterable<E> iterable){
        LinkedList<E> linkedList = new LinkedList<>();
        int acc = 0;
        for(E e: iterable){
            acc += 1;
            linkedList.add(e);
            ps.print(String.valueOf(acc)+": ");
            ps.println(e);
        }
        try{
            int chosen = Integer.parseInt(scn.nextLine());
            return linkedList.get(chosen-1);
        } catch (NumberFormatException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
