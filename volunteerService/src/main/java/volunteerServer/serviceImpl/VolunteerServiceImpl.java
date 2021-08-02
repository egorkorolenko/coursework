package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import volunteerServer.converters.RequestConverter;
import volunteerServer.converters.ResponseConverter;
import volunteerServer.converters.VolunteerConverter;
import volunteerServer.dto.RequestDto;
import volunteerServer.dto.ResponseDto;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Request;
import volunteerServer.entity.Response;
import volunteerServer.entity.Volunteer;
import volunteerServer.error.ServiceErrorCode;
import volunteerServer.error.ServiceException;
import volunteerServer.repository.RequestRepository;
import volunteerServer.repository.ResponseRepository;
import volunteerServer.repository.VolunteerRepository;
import volunteerServer.service.VolunteerService;
import volunteerServer.serviceUtils.VolunteerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Service
@Log
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final ResponseConverter responseConverter;
    private final VolunteerRepository volunteerRepository;
    private final RequestRepository requestRepository;
    private final ResponseRepository responseRepository;
    private final VolunteerConverter volunteerConverter;
    private final RequestConverter requestConverter;
    private final VolunteerUtils volunteerUtils;

    @Override
    public VolunteerDto registerVolunteer(VolunteerDto dto) throws ServiceException {
        volunteerUtils.validateDto(dto);
        Volunteer volunteer = volunteerRepository.save(volunteerConverter.fromVolunteerDtoToVolunteer(dto));
        return volunteerConverter.fromVolunteerToVolunteerDto(volunteer);
    }

    @Override
    public VolunteerDto loginVolunteer(String login, String password) {
        return null;
    }

    @Override
    public VolunteerDto findByLogin(String login) throws ServiceException {
        if (login == null || login.equals("")) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_LOGIN));
            throw new ServiceException(ServiceErrorCode.INVALID_LOGIN);
        }
        Volunteer volunteer = volunteerRepository.findByLogin(login);
        if (volunteer != null) {
            return volunteerConverter.fromVolunteerToVolunteerDto(volunteer);
        }
        log.info(String.valueOf(ServiceErrorCode.LOGIN_NOT_FOUND));
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }

    @Override
    public void logoutVolunteer(String login) {

    }

    @Override
    public void deleteVolunteer(Integer id) throws ServiceException {
        if (id == null) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_ID));
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        volunteerRepository.deleteById(id);
    }

    @Override
    public List<VolunteerDto> getAllVolunteer() {
        return volunteerRepository.findAll()
                .stream()
                .map(volunteerConverter::fromVolunteerToVolunteerDto)
                .collect(Collectors.toList());
    }

    @Override
    public VolunteerDto getById(Integer id) throws ServiceException {
        if (id == null) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_ID));
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        Optional<Volunteer> volunteer = volunteerRepository.findById(id);
        if (volunteer.isPresent()) {
            return volunteerConverter.fromVolunteerToVolunteerDto(volunteer.get());
        }
        log.info(String.valueOf(ServiceErrorCode.LOGIN_NOT_FOUND));
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }

    @Override
    public List<Request> getClientRequest() {
        return requestRepository
                .findAll()
                .stream()
                .filter(not(Request::getRequest_is_ready))
                .collect(Collectors.toList());
    }

    @Override
    public RequestDto takeRequest(Integer id, Integer idRequest) {
        return requestConverter
                .fromRequestToRequestDto(requestRepository.findById(idRequest).get());
    }

    @Override
    public ResponseDto sendResponse(Integer id, ResponseDto report) throws ServiceException {
        if (requestRepository.findById(report.getIdRequest()).get().getRequest_is_ready()) {
            throw new ServiceException(ServiceErrorCode.REQUEST_ALREADY_READY);
        }
        if (report.getResponse() == null || report.getResponse().equals("")) {
            throw new ServiceException(ServiceErrorCode.INVALID_REPORT);
        }

        if (report.getIdVolunteer() == null)
            report.setIdVolunteer(id);

        if (report.getIsReady()) {
            requestRepository.getById(report.getIdRequest()).setId_volunteer(volunteerRepository.findById(id).get());
            requestRepository.getById(report.getIdRequest()).setRequest_is_ready(true);
        }
        Response response = responseRepository.save(responseConverter.fromResponseDtoToResponse(report));
        return responseConverter.fromResponseToResponseDto(response);
    }

    @Override
    public List<ResponseDto> getMyReports(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        Volunteer volunteer = volunteerConverter.fromVolunteerDtoToVolunteer(getById(id));
        return responseRepository.findAll()
                .stream()
                .filter(response -> response.getIdVolunteer().equals(volunteer))
                .map(responseConverter::fromResponseToResponseDto)
                .collect(Collectors.toList());
    }
}
