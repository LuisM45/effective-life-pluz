package net.epnmag9.effectivelifepluz.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

import net.epnmag9.effectivelifepluz.controllers.Identificador;
import net.epnmag9.lib.NombresValidador;

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


    public <E> E readLineAndParseUntilSuccess(Function<String,E> parseFunction,String beginMessage, String successMessage, String errorMessage){
        printNNull(beginMessage);
        
        while(true){
            try {
                E returnVal = scanner.nextLine().transform(parseFunction);
                printNNull(successMessage);
                
                return returnVal;
            } catch (Exception e) {
                printNNull(errorMessage);
            }
        }

    }

    public Identificador readIdentificadorUntilSuccess(){
        String type = chooseFromUntilSuccess(Identificador.builders.keySet(),"Seleccione el tipo de identificador a ocupar: ",null,"Intente de nuevo: ");

        Function<String,Identificador> builder = Identificador.builders.get(type);
        return readLineAndParseUntilSuccess(builder,String.format("Ingrese el valor de %s: ", type),null,"Entrada no válida, intente de nuevo:");
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

    public String readNameUntilSuccess(String beginMessage, String successMessage, String errorMessage){
        Function<String,String> parseFunction = (s)->{
            if(!NombresValidador.validate(s))
                throw new RuntimeException("Not valid format");
            return s;
        };
        return readLineAndParseUntilSuccess(parseFunction, beginMessage, successMessage, errorMessage);
    }

    private Date parseDate(String string, String format){
        try {
            return (new SimpleDateFormat(format).parse(string));
        } catch (ParseException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public <E> E chooseFromUntilSuccess(Iterable<E> iterable,String beginMessage,String successMessage, String errorMessage){
        printNNull(beginMessage);
        while(true){
            E returnVal = chooseFrom(iterable);
            if (returnVal == null) {
                if(errorMessage != null)
                printStream.println(errorMessage);
                continue;
            }
            printNNull(successMessage);
            return returnVal;
        }
    }

    public <E> E chooseFrom(Iterable<E> iterable){
        LinkedList<E> linkedList = new LinkedList<>();
        for(E e: iterable) 
            linkedList.add(e);
        printStream.println(getListString(linkedList));
        try{
            int chosen = Integer.parseInt(scanner.nextLine());
            return linkedList.get(chosen-1);
        } catch (NumberFormatException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String getListString(List<?> list){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(Object o: list){
            index += 1;
            sb.append(String.valueOf(index)).append(": ").append(o.toString());
        }
        return sb.toString();
    }

    public Scanner getIn() {
        return scanner;
    }

    public PrintStream getOut() {
        return printStream;
    }
    
}
