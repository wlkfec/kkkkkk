package com.example.springsecurity101cloudoauth2userservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    private static String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidXNlcnNlcnZpY2UiXSwidXNlcl9uYW1lIjoicmVhZGVyIiwic2NvcGUiOlsiZjEiLCJmMiJdLCJleHAiOjE2MDkxMzIyOTksInVzZXJEZXRhaWxzIjp7InBhc3N3b3JkIjpudWxsLCJ1c2VybmFtZSI6InJlYWRlciIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJhMSxhMixhMyxhNCxhNSJ9XSwiYWNjb3VudE5vbkV4cGlyZWQiOnRydWUsImFjY291bnROb25Mb2NrZWQiOnRydWUsImNyZWRlbnRpYWxzTm9uRXhwaXJlZCI6dHJ1ZSwiZW5hYmxlZCI6dHJ1ZX0sImRlbW8iOiJzb21lIiwiYXV0aG9yaXRpZXMiOlsiYTEsYTIsYTMsYTQsYTUiXSwianRpIjoiNTE3ZWIxNjMtNDRlZS00ODQ5LTgyMzItYTEyYmI0NWMyMDBhIiwiY2xpZW50X2lkIjoidXNlcnNlcnZpY2UxIn0.dSi4u04gkdm9W5OkNFq1owLv83rA-dCj1T1ylxkIx5m8qBvcFe1WmJDcevgCFxPg7drvpt-drdCI2gWrJu5NNJLUwwPS_M20HYWvERqgJuuqeTYz0gACuWeLIT97fgileNMNrkIk6ldVadSL2ytWg6Ek9Nyq5Z_TAHzML6TRd6hlyIQXsm5keiSCNeZgsbhq108rM7IJUIPSgayWtxQFwuwX1gHEJrUZGvILH_Q3R6jVDxzBiHtzof1eYChncM5Wsj_S4xRGRKE5LdI893yWBQlmIiRi9HPxJtB839a9TwTykm_AaKoiFnBbKE4MjBa9GQzvZbOKrXucbSoxok7CmQ";

    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }

    public static void main(String[] args) {
        System.out.println(JwtHelper.decode(token).getClaims());
    }
}
