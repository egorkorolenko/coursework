package volunteerServer.serviceUtils;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import volunteerServer.dto.ClientDto;
import volunteerServer.error.ServiceErrorCode;
import volunteerServer.error.ServiceException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

@Log
@Component
public class ClientUtils {
    public void validateDto(ClientDto clientDto) throws ServiceException {
        if (clientDto == null) {
            log.info(String.valueOf(ServiceErrorCode.OBJECT_CANNOT_BE_NULL));
            throw new ServiceException(ServiceErrorCode.OBJECT_CANNOT_BE_NULL);
        }
        if (clientDto.getUsername() == null || !clientDto.getUsername().matches("[А-Яа-яЁёA-Za-z0-9_\\s]+")) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_USERNAME));
            throw new ServiceException(ServiceErrorCode.INVALID_USERNAME);
        }
        if (!checkDate(clientDto.getBirthdate())) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_BIRTHDATE));
            throw new ServiceException(ServiceErrorCode.INVALID_BIRTHDATE);
        }
        if (!clientDto.getEmail().matches("[a-zA-Z0-9]{1,}[@]{1}[a-z]{5,}[.]{1}+[a-z]{3}")) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_EMAIL));
            throw new ServiceException(ServiceErrorCode.INVALID_EMAIL);
        }
        if (!clientDto.getLogin().matches("^[A-Za-z]([\\.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_LOGIN));
            throw new ServiceException(ServiceErrorCode.INVALID_LOGIN);
        }
        if (!clientDto.getPassword().matches("^[A-Za-z]([\\.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_PASSWORD));
            throw new ServiceException(ServiceErrorCode.INVALID_PASSWORD);
        }
    }

    public boolean checkDate(String date) throws ServiceException {
        LocalDate birthdate =
                LocalDate.parse(date,
                        DateTimeFormatter.ofPattern("dd.MM.uuuu")
                                .withResolverStyle(ResolverStyle.STRICT));
        Period period = Period.between(birthdate, LocalDate.now());
        if ((period.getYears() < 18)) {
            log.info(String.valueOf(ServiceErrorCode.AGE_MUST_OVER_18_YEARS_OLD));
            throw new ServiceException(ServiceErrorCode.AGE_MUST_OVER_18_YEARS_OLD);
        }
        return birthdate.isAfter(LocalDate.now().minusYears(120));
    }
}