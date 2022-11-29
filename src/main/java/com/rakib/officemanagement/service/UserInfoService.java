package com.rakib.officemanagement.service;

import com.rakib.officemanagement.model_repository.UserInfoRepository;
import com.rakib.officemanagement.service.dtos.UserInfoDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfoService(UserInfoRepository userInfoRepository, PasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<ServerResponse> createUserInfo(ServerRequest serverRequest) {
        var userInfoMono = serverRequest.bodyToMono (UserInfoDTO.class);
        Mono<UserInfoDTO> userInfoDTOMono = userInfoMono.map (userInfoDTO -> {
                    System.out.println (userInfoDTO);
                    return userInfoDTO;
                })
                .doOnError (throwable -> System.out.println (throwable.getMessage ()));
        return ServerResponse.ok ().body (BodyInserters.fromValue (userInfoDTOMono.cache ()));
//        return userInfoMono
//                .switchIfEmpty (Mono.error (new Throwable ("request data can not be empty")))
//                .map (userInfo -> {
//                    if (Objects.isNull (userInfo.getEmail ()))
//                        throw new RuntimeException ("user email can not empty");
//                    if (Objects.isNull (userInfo.getPassword ()))
//                        throw new RuntimeException ("user password can not empty");
//                    if (Objects.isNull (userInfo.getUserRole ()))
//                        throw new RuntimeException ("user role can not empty");
//                    return userInfo;
//                })
//                .map (userInfo -> {
//                    userInfo.setCreatedBy (userInfo.getEmail ());
//                    userInfo.setUpdatedBy (userInfo.getEmail ());
//                    userInfo.setCreateDate (Instant.now ());
//                    userInfo.setUpdateDate (Instant.now ());
//                    userInfo.setPassword (passwordEncoder.encode (userInfo.getPassword ()));
//                    return userInfo;
//                })
//                .doOnNext (userInfoRepository::save)
//                .doOnNext (userInfo -> Mono.just (UserInfoDTO.toDTO (userInfo)))
//                .flatMap (userInfoDTO -> CommonUtils.successResponse (HttpStatus.CREATED, "created", userInfoDTO))
//                .doOnError (throwable -> System.out.println (throwable.getMessage ()));
    }

    public Mono<ServerResponse> updateUserInfo(String id, ServerRequest serverRequest) {
        return null;
    }


    public Mono<ServerResponse> getUserByEmail(String email) {
        return null;
    }


    public Flux<ServerResponse> getAllUserInfo() {
        return null;
    }

    public Mono<ServerResponse> deleteUserInfo(String id) {
        return null;
    }
}
