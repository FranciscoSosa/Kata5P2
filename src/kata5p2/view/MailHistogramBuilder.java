package kata5p2.view;

import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import java.util.List;

public class MailHistogramBuilder {
    private MailHistogramBuilder(){}

    public static Histogram<String> build(List<Mail> mailList){
        Histogram<String> histogram = new Histogram<>();
        for (Mail mail : mailList) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
