package juja.microservices.teams.service;

import juja.microservices.teams.dao.TeamRepository;
import juja.microservices.teams.entity.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Andrii.Sidun
 */

@RunWith(SpringRunner.class)
@WebMvcTest(TeamService.class)
public class TeamsServiceTest {

    @Inject
    @InjectMocks
    private TeamService teamService;

    @MockBean
    private TeamRepository teamRepository;

    final String creator = "f827811f-51e8-4fc4-a56d-aebcd2193bc4";
    final String uuidOne = "f827811f-51e8-4fc4-a56d-aebcd2193bc3";
    final String uuidTwo = "f827811f-51e8-4fc4-a56d-aebcd2193bc2";
    final String uuidThree = "f827811f-51e8-4fc4-a56d-aebcd2193bc1";
    final String uuidFour = "f827811f-51e8-4fc4-a56d-aebcd2193bc0";

    @Test
    public void addTeam(){
        //Given
        String expected = "SomeId";
        Team team = new Team(creator, uuidOne, uuidTwo, uuidThree, uuidFour);
        when(teamRepository.save(team)).thenReturn("SomeId");
        //When
        String result = teamService.addTeam(team);
        //Then
        assertEquals(expected, result);
    }

}