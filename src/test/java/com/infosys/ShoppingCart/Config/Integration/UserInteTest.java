/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosys.ShoppingCart.Config.Integration;

import com.infosys.shoppingcart.models.UserModel;
import java.net.URI;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Adriana
 * 
 * As the name suggests, integration tests focus on integrating different 
 * layers of the application. That also means no mocking is involved.
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserInteTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    private static final String url = "http://localhost:";
    
    @Test
    @Ignore
    public void exampleTest() {
         String body = this.restTemplate.getForObject(url, String.class);
         System.out.println(body);
         assertThat(body).containsIgnoringCase("yova");
    }
    
    @Test
   // @Ignore
    public void loginTest() {
              
       UserModel response = restTemplate.postForObject(url+port+"/users/login",
               new UserModel(50,"yovanotti","yova"), UserModel.class);
       
       assertThat(response.getUsername())
                .isEqualTo("yovanotti");
       assertThat(response.getName())
                .isEqualTo("Yovannys Sanchez");        
    }
    
    
    @Test
    public void searchUsersTest() {
              
       HttpHeaders headers = new HttpHeaders();
       headers.set("Api-Token", "367593b2-2eec-49e6-8ea3-809f08d8c74a+MTUwOTczMDcyNg=="); 
   
       HttpEntity request = new HttpEntity(headers);
       ResponseEntity<UserModel[]> response = restTemplate.exchange(url+port+"/users/search?username=yova", HttpMethod.GET, request, UserModel[].class);      
       
       UserModel[] objects = response.getBody();
           
       assertThat(objects[0].getUsername())
                .isEqualTo("yovanotti");
             
    }
    
    /*    DADO:
     
        @PostMapping(path="/savePersonList")
        @ResponseBody
        public List<Person> generatePersonList(@RequestBody List<Person> person){
            return iPersonRestService.generatePersonList(person);
        }
    
    
        CLIENT
    
       //header
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //person list
        List<Person> personList = new ArrayList<Person>();
        Person person = new Person();
        person.setName("UserOne");  
        personList.add(person);
        //httpEnitity       
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(personList,headers);
        ResponseEntity<List<Person>> rateResponse = restTemplate.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<List<Person>>() {});

    */
}
