package net.ranayo.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class errorHandler implements ErrorController {
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            int statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "error-404";
            }
            if(statusCode == HttpStatus.FORBIDDEN.value()){
                return "error-403";
            }
        }
        return "error";
}
	@Override
    public String getErrorPath() {
        return "/error";
    }
/**
 * ���������� �ڵ鷯 Ŭ����
 */
   
}
