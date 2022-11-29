package com.rakib.officemanagement.service.dtos;

import com.rakib.officemanagement.model.UserInfo;
import com.rakib.officemanagement.service.enums.Roles;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private Roles userRole;
    private Boolean userIsActive;

    public static UserInfoDTO toDTO(UserInfo userInfo) {
        return UserInfoDTO.builder ()
                .id (userInfo.getId ().toHexString ())
                .name (userInfo.getName ())
                .email (userInfo.getEmail ())
                .userRole (userInfo.getUserRole ())
                .userIsActive (userInfo.isUserIsActive ())
                .build ();
    }
}
