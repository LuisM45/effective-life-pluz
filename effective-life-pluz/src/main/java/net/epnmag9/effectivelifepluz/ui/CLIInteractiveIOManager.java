package net.epnmag9.effectivelifepluz.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

import net.epnmag9.effectivelifepluz.controllers.Identificador;

public class CLIInteractiveIOManager {
    private Scanner scanner;
    private PrintStream printStream;
    public CLIInteractiveIOManager(InputStream inputStream, PrintStream printStream) {
        scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }
    
    public String nextLine(String message){
        printNNull(message);
        return scanner.nextLine();
    }

    public void printNNull(Object o){
        if(o == null) return;
        printStream.print(o.toString());
}

    public String readLineUntilTrue(Predicate<String> predicate, String beginMessage, String trueMessage, String falseMessage, String errorMessage){
        printNNull(beginMessage);
        while(true){
            String input = scanner.nextLine();
            try {
                boolean result = predicate.test(input);
                if(result){
                    printNNull(trueMessage);
                        return input;
                }
                printNNull(falseMessage);
            } catch (Exception e) {
                printNNull(errorMessage);
            }
        }

    }

    public <E> E readLineAndParseUntilSuccess(Function<String,E> parseFunction,String beginMessage, String successMessage, String errorMessage){
        printNNull(beginMessage);
        
        while(true){
            String input = scanner.nextLine();
            try {
                E returnVal = parseFunction.apply(input);
                printNNull(successMessage);
                
                return returnVal;
            } catch (Exception e) {
                printNNull(errorMessage);
            }
        }

    }

    public Identificador readIdentificadorUntilSuccess(){
        printStream.println("Seleccione el tipo de identificador a ocupar: ");
        String type = chooseFromUntilSuccess(Identificador.recognizedIdentifiersView.keySet(),"Intente de nuevo");
        printStream.println();

        Function<String,Identificador> parseFun = t->Identificador.buildIdentificador(t, type);
        return readLineAndParseUntilSuccess(parseFun,String.format("Ingrese el valor de %s: ", type),null,"Entrada no válida");
    }

    public Double readDoubleUntilSuccess(String beginMessage, String successMessage, String errorMessage){
        return readLineAndParseUntilSuccess(Double::valueOf,beginMessage, successMessage, errorMessage);
    }

    public Integer readIntegerUntilSuccess(String beginMessage, String successMessage, String errorMessage){
        return readLineAndParseUntilSuccess(Integer::valueOf, beginMessage, successMessage, errorMessage);
    }

    public Date readDateUntilSuccess(String beginMessage, String format,String successMessage, String errorMessage){
        Function<String,Date> parseFunction = (s)->parseDate(s,format);
        return readLineAndParseUntilSuccess(parseFunction, beginMessage, successMessage, errorMessage);
    }

    private Date parseDate(String string, String format){
        try {
            return (new SimpleDateFormat(format).parse(string));
        } catch (ParseException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public <E> E chooseFromUntilSuccess(Iterable<E> iterable,String errorMessage){
        while(true){
            E returnVal = chooseFrom(iterable);
            if (returnVal == null) {
                if(errorMessage != null)
                    printStream.println(errorMessage);
                    continue;
            }
            return returnVal;
        }
    }

    public <E> E chooseFrom(Iterable<E> iterable){
        LinkedList<E> linkedList = new LinkedList<>();
        int acc = 0;
        for(E e: iterable){
            acc += 1;
            linkedList.add(e);
            printStream.print(String.valueOf(acc)+": ");
            printStream.println(e);
        }
        try{
            int chosen = Integer.parseInt(scanner.nextLine());
            return linkedList.get(chosen-1);
        } catch (NumberFormatException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Scanner getIn() {
        return scanner;
    }

    public PrintStream getOut() {
        return printStream;
    }
    
}
