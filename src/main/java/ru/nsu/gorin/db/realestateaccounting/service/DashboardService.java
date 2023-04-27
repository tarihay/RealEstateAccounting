package ru.nsu.gorin.db.realestateaccounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.gorin.db.realestateaccounting.model.dto.dashboardRelated.DashboardDTO;
import ru.nsu.gorin.db.realestateaccounting.model.entities.userRelated.User;
import ru.nsu.gorin.db.realestateaccounting.repository.*;
import ru.nsu.gorin.db.realestateaccounting.utils.exceptions.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ObjectRepository objectRepository;
    private final EventRepository eventRepository;
    private final SolutionRepository solutionRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public DashboardDTO getDashboard(Integer userId) {
        User user = userRepository.findById(userId.longValue())
                .orElseThrow(() -> new UserNotFoundException("нет пользователя с id =  " + userId));
        DashboardDTO dto = new DashboardDTO();
        return null; //TODO доделать дашборд
    }


}
