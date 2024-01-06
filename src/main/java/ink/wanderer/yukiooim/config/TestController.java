package ink.wanderer.yukiooim.config;

import ink.wanderer.yukiooim.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(HttpSession session) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Login DEBUG:\n");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            stringBuilder.append("Username: " + username + "\n");
        }
        listSessionAttributes(session);
        stringBuilder.append("Session: " + session.getAttribute("SPRING_SECURITY_CONTEXT").toString() + "\n");
        return stringBuilder.toString();
    }
    public void listSessionAttributes(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = session.getAttribute(attributeName);
            System.out.println(attributeName + " : " + attributeValue);
        }
    }
}
