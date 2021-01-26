package com.test.interview.controller;


import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.interview.entity.Palindrome;
import com.test.interview.repo.PlaindromesRepository;


@RestController

public class PalindromesApi {
    @Autowired
    PlaindromesRepository repo;
    
    @GetMapping(value = "/api/PalindromeString")
    public ResponseEntity<String> palindromeString(@RequestParam("palinDromeString") String str) throws IOException {
        String rtrnString =maxPalSubstr(str); 
                  
        return new ResponseEntity<String>(rtrnString,HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/api/palindromeString")
    public ResponseEntity<Palindrome> palindromeSave(@RequestBody (required = true) String str) throws IOException {
        Palindrome p=new Palindrome();
        p.setPalindrome(str);
        p.setTransactionDate(new Date(System.currentTimeMillis()));
        return new ResponseEntity<Palindrome>(repo.save(p),HttpStatus.CREATED);
    }
    
    

    @GetMapping(value = "/api/largestPalindrome")
    public ResponseEntity<Palindrome> getLargestPalindrome() throws IOException {
        return new ResponseEntity<Palindrome>(repo.findLargestPalindrome(),HttpStatus.CREATED);
    }
    
   
    
    private  String maxPalSubstr(String str)
    {
        int maxLength = 1, start = 0;
     
        
        for (int i = 0; i < 1000; i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;
     
                
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;
     
                
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
     return str.substring(start, start+maxLength-1);
        
    }

    
    
    
}