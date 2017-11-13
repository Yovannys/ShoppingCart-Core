package com.infosys.shoppingcart.components;

import com.infosys.shoppingcart.models.UserModel;
import com.infosys.shoppingcart.repositories.LogRepository;
import com.infosys.shoppingcart.services.UserService;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



/*
 * Por cada peticion que se haga entre por esta clase
 * */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	@Qualifier("logRepository")
	LogRepository logRepository;
        
        @Autowired
        @Qualifier("userServiceImpl")
        private UserService userService;
	
	private static final Log LOGGER =  LogFactory.getLog(RequestTimeInterceptor.class);

	//Se ejecuta antes de entrar al controlador
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	
	//Se ejecuta antes de entrar de escupir la vista en el navegador 
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		long startTime = (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
                
                String user = null;
                UserModel userAuth = userService.getUsernameByToken();
                if (userAuth!=null){
                    try {
                         user = userService.getUsernameByToken().getUsername();
                    } catch (Exception e) {
                       // user = null;
                    }
                }               
                  else
                 user = "Anonymous";
		
		logRepository.save( new com.infosys.shoppingcart.entities.Log(new Date(), user, url));
		
		LOGGER.info("' -- TOTAL TIME: '"+(System.currentTimeMillis()-startTime)+"'ms");
	}
	 
}
