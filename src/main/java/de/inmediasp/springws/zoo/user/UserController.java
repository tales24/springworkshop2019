package de.inmediasp.springws.zoo.user;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    public UserController(final OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }

    @GetMapping("/user")
    public String getUser(final OAuth2Authentication oAuth2AuthenticationToken) {
        final OAuth2AuthorizedClient oAuth2AuthorizedClient = oAuth2AuthorizedClientService.loadAuthorizedClient("okta", oAuth2AuthenticationToken.getName());

        return oAuth2AuthenticationToken.getName() + " from " + oAuth2AuthorizedClient.getClientRegistration().getClientName();
    }
}
