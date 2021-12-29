package kata5p2.view;

import kata5p2.model.Mail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    private MailListReader(){}

    public static List<Mail> read(String filename){
        List<Mail> mailList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null){
                if(line.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
                    mailList.add(new Mail(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("(ERROR) File not found");
        } catch (IOException e) {
            System.out.println("(ERROR) IOException");
        }
        return mailList;
    }
}
