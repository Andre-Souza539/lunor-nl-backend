package br.dev.nerdlab.lunor.adapters.in.web;

import br.dev.nerdlab.lunor.application.ports.in.CompleteReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.in.CreateReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.in.ListReminderUseCase;
import br.dev.nerdlab.lunor.domain.Reminder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reminders")
public class ReminderController {

    private final CreateReminderUseCase createReminderUseCase;
    private final ListReminderUseCase listReminderUseCase;
    private final CompleteReminderUseCase completeReminderUseCase;

    @PostMapping
    public ResponseEntity<ReminderResponse> create(@RequestBody CreateReminderRequest reminderRequest) {

        CreateReminderUseCase.Command command = new CreateReminderUseCase.Command(
                reminderRequest.title(), reminderRequest.dueDate());

        Reminder result = createReminderUseCase.execute(command);

        ReminderResponse response = ReminderResponse.from(result);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ReminderResponse>> list() {
        List<Reminder> result = listReminderUseCase.execute();
        List<ReminderResponse> response = result.stream()
                .map(ReminderResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Void> complete(@PathVariable UUID id) {
        completeReminderUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    public record CreateReminderRequest(String title, LocalDateTime dueDate) {
    }

    public record ReminderResponse(UUID id, String title, LocalDateTime dueDate, boolean completed) {
        public static ReminderResponse from(Reminder reminder) {
            return new ReminderResponse(
                    reminder.getId(),
                    reminder.getTitle(),
                    reminder.getDueDate(),
                    reminder.isCompleted()
            );
        }
    }


}
