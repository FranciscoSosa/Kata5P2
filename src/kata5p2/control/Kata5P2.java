package kata5p2.control;

import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

import java.util.List;

public class Kata5P2 {
    private static List<Mail> mailList;
    private static Histogram<String> histogram;
    private static final String filename = "email.txt";

    public static void main(String[] args) {
        execute();
    }

    private static void input(){
        mailList = MailListReader.read(filename);
    }

    private static void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }

    private static void output(){
        new HistogramDisplay(histogram).execute();
    }

    private static void execute(){
        input();
        process();
        output();
    }
}
