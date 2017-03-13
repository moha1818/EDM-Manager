package utils.sendemail;

import java.util.Map;

public interface EmailService {
    void sendEmail(Map<String, Object> contentMap, String TemplateNameOrContent, String targetEmail, String subject);
    void sendEmail(String TemplateNameOrContent, String targetEmail, String subject);
}
