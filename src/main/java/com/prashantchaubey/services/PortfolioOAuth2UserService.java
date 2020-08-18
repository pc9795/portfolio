package com.prashantchaubey.services;

import com.prashantchaubey.beans.oauth.OAuth2UserInfo;
import com.prashantchaubey.beans.oauth.OAuth2UserInfoFactory;
import com.prashantchaubey.config.UserPrincipal;
import com.prashantchaubey.entities.User;
import com.prashantchaubey.repositories.UserRepository;
import com.prashantchaubey.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioOAuth2UserService extends DefaultOAuth2UserService {
  private UserRepository userRepository;

  @Autowired
  public PortfolioOAuth2UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(userRequest);
    try {
      return processOAuth2User(userRequest, oAuth2User);
    } catch (AuthenticationException exc) {
      throw exc;
    } catch (Exception exc) {
      // Throwing an instance of `AuthenticationException` will trigger the
      // `OAuth2AuthenticationFailureHandler`
      throw new InternalAuthenticationServiceException(exc.getMessage(), exc.getCause());
    }
  }

  private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
    String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
    OAuth2UserInfo oAuth2UserInfo =
        OAuth2UserInfoFactory.getOAuthUser2Info(registrationId, oAuth2User.getAttributes());
    if (!Utils.isNotBlank(oAuth2UserInfo.getEmail())) {
      throw new RuntimeException("Email not found from OAuth2 provider");
    }

    Optional<User> maybeUser = userRepository.findByEmail(oAuth2UserInfo.getEmail());
    User user;
    if (!maybeUser.isPresent()) {
      user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
    } else {
      user = maybeUser.get();
      if (!user.getProvider().equals(User.AuthProvider.fromValue(registrationId))) {
        throw new RuntimeException(
            String.format(
                "Looks like you're signed up with %s account. "
                    + "Please use your same account to login",
                user.getProvider()));
      }
      user = updateExistingUser(user, oAuth2UserInfo);
    }

    return UserPrincipal.create(user, oAuth2User.getAttributes());
  }

  private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
    User.UserBuilder builder =
        User.builder()
            .name(oAuth2UserInfo.getName())
            .email(oAuth2UserInfo.getEmail())
            .imageUrl(oAuth2UserInfo.getImageUrl())
            .provider(
                User.AuthProvider.fromValue(
                    oAuth2UserRequest.getClientRegistration().getRegistrationId()))
            .providerId(oAuth2UserInfo.getId());

    return userRepository.save(builder.build());
  }

  private User updateExistingUser(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
    User.UserBuilder builder =
        User.builder()
            .id(existingUser.getId())
            .name(oAuth2UserInfo.getName())
            .email(existingUser.getEmail())
            .imageUrl(oAuth2UserInfo.getImageUrl())
            .emailVerified(existingUser.isEmailVerified())
            .password(existingUser.getPassword())
            .provider(existingUser.getProvider())
            .providerId(existingUser.getProviderId());

    return userRepository.save(builder.build());
  }
}
