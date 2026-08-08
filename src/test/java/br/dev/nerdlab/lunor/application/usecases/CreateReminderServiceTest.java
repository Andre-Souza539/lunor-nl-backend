package br.dev.nerdlab.lunor.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.dev.nerdlab.lunor.application.ports.in.CreateReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.out.ReminderRepositoryPort;
import br.dev.nerdlab.lunor.domain.DomainException;
import br.dev.nerdlab.lunor.domain.Reminder;

public class CreateReminderServiceTest {
 
    private ReminderRepositoryPort repositoryPort;
    private CreateReminderService createReminderService;

    @BeforeEach
    void setUp() {
        this.repositoryPort = mock(ReminderRepositoryPort.class);
        this.createReminderService = new CreateReminderService(repositoryPort);
    }

    @Test
    @DisplayName("Should Create a reminder successfully when input is valid")
    void shouldCreateReminderSuccessfully(){

        //GIVEN
        CreateReminderUseCase.Command command = new CreateReminderUseCase.Command(
            "Study Hexagonal Architecture",
            LocalDateTime.now().plusDays(2)
        );

        when(repositoryPort.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Reminder result = createReminderService.execute(command);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(command.title(), result.getTitle());
        assertEquals("Study Hexagonal Architecture", result.getTitle());
        assertFalse(result.isCompleted());

        verify(repositoryPort, times(1)).save(any(Reminder.class));

    }

    @Test
    @DisplayName("Should throw exception when title is empty")
    void shouldThrowExceptionWhenTitleIsEmpty(){

        //GIVEN
        CreateReminderUseCase.Command command = new CreateReminderUseCase.Command(
            "",
            LocalDateTime.now().plusDays(2)
        );

        assertThrows(DomainException.class, () -> createReminderService.execute(command));
        verifyNoInteractions(repositoryPort);

    }


}
