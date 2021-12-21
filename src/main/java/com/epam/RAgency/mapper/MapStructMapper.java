package com.epam.RAgency.mapper;

import com.epam.RAgency.dto.ApplicationDto;
import com.epam.RAgency.dto.UserGetDto;
import com.epam.RAgency.dto.UserPostDto;
import com.epam.RAgency.model.Application;
import com.epam.RAgency.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    UserGetDto mapUserToUserGetDto(User user);

    User mapUserPostDtoToUser(UserPostDto dto);

    ApplicationDto mapApplicationToApplicationDto(Application application);

    Application mapApplicationDtoToApplication(ApplicationDto dto);
}