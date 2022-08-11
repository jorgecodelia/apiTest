package apiTest.service;

import apiTest.common.NotFoundException;
import apiTest.common.ServiceException;
import apiTest.domain.User;
import apiTest.domain.UserResponse;
import apiTest.repository.UserEntity;
import apiTest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

      private UserRepository userRepository;
      private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

      public User getUserById(String userId){
            try {
                  Optional<UserEntity> userEntityOptional = userRepository.findByUserid(userId);
                  if (userEntityOptional.isPresent()){
                        UserEntity userEntity = userEntityOptional.get();
                        return User.builder()
                                .userId(userEntity.getUserid())
                                .firstName(userEntity.getFirst_name())
                                .lastName(userEntity.getLast_name())
                                .birthDate(userEntity.getDate_of_birth())
                                .phoneNumber(userEntity.getPhone_number())
                                .phoneCountryCode(userEntity.getPhone_country_code())
                                .country(userEntity.getCountry())
                                .email(userEntity.getEmail())
                                .build();
                  }

            }catch (Exception e){
                  LOGGER.error(this.getClass().getName());
                  LOGGER.error("getUserById");
                  LOGGER.error(e.getMessage());
                  throw new ServiceException("ServiceError", e.getMessage(), e);
            }
            throw new NotFoundException("User Not Found", null, null);
      }

      public boolean updateUser(User user){
            try {
                  Optional<UserEntity> userEntityOptional = userRepository.findByUserid(user.getUserId());
                  if (userEntityOptional.isPresent()){
                        UserEntity userEntity = userEntityOptional.get();
                        userEntity.setFirst_name(user.getFirstName());
                        userEntity.setLast_name(user.getLastName());
                        userEntity.setDate_of_birth(user.getBirthDate());
                        userEntity.setPhone_number(user.getPhoneNumber());
                        userEntity.setPhone_country_code(user.getPhoneCountryCode());
                        userEntity.setCountry(user.getCountry());
                        userEntity.setEmail(user.getEmail());
                        userRepository.saveAndFlush(userEntity);
                        return true;
                  }
            }catch (Exception e){
                  LOGGER.error(this.getClass().getName());
                  LOGGER.error("getUserById");
                  LOGGER.error(e.getMessage());
                  throw new ServiceException("ServiceError", e.getMessage(), e);
            }
            throw new NotFoundException("User Not Found", null, null);
      }

      public UserResponse getUsers(){
            try {
                  List<UserEntity> userEntityList = userRepository.findAll();
                  List<User> users = new ArrayList<>();
                  for (UserEntity userEntity: userEntityList) {
                        User user = User.builder()
                                .userId(userEntity.getUserid())
                                .firstName(userEntity.getFirst_name())
                                .lastName(userEntity.getLast_name())
                                .birthDate(userEntity.getDate_of_birth())
                                .phoneNumber(userEntity.getPhone_number())
                                .phoneCountryCode(userEntity.getPhone_country_code())
                                .country(userEntity.getCountry())
                                .email(userEntity.getEmail())
                                .build();
                        users.add(user);
                  }
                  return UserResponse.builder()
                          .userList(users)
                          .build();

            }catch (Exception e){
                  LOGGER.error(this.getClass().getName());
                  LOGGER.error("getUsers");
                  LOGGER.error(e.getMessage());
                  throw new ServiceException("ServiceError", e.getMessage(), e);
            }
      }

      public boolean createUser(User user){
            try {
                  UserEntity userEntity = UserEntity.builder()
                          .userid(UUID.randomUUID().toString())
                          .first_name(user.getFirstName())
                          .last_name(user.getLastName())
                          .date_of_birth(user.getBirthDate())
                          .phone_number(user.getPhoneNumber())
                          .phone_country_code(user.getPhoneCountryCode())
                          .country(user.getCountry())
                          .email(user.getEmail())
                          .build();
                  userRepository.save(userEntity);
                  return true;
            }catch (Exception e) {
                  LOGGER.error(this.getClass().getName());
                  LOGGER.error("createUser");
                  LOGGER.error(e.getMessage());
                  throw new ServiceException("ServiceError", e.getMessage(), e);
            }
      }


      public boolean deleteUserById(String userId){
            try {
                  Optional<UserEntity> userEntityOptional = userRepository.findByUserid(userId);
                  if (userEntityOptional.isPresent()){
                        UserEntity userEntity = userEntityOptional.get();
                        userRepository.delete(userEntity);
                        return true;
                  }
            }catch (Exception e){
                  LOGGER.error(this.getClass().getName());
                  LOGGER.error("deleteUserById");
                  LOGGER.error(e.getMessage());
                  throw new ServiceException("ServiceError", e.getMessage(), e);
            }
            throw new NotFoundException("User Not Found", null, null);
      }
}
