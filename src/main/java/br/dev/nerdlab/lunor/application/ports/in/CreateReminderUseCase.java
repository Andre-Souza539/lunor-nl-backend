package br.dev.nerdlab.lunor.application.ports.in;

import java.time.LocalDateTime;

import br.dev.nerdlab.lunor.domain.Reminder;

public interface CreateReminderUseCase {
    Reminder execute(Command command);

    record Command(String title, LocalDateTime dueDate){}
}