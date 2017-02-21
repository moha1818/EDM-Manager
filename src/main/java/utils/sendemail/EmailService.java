package utils.sendemail;

import java.util.Map;

public interface EmailService {
    public void sendEmail(Map<String, Object> contentMap, String TemplateNameOrContent, String targetEmail, String subject);
}
