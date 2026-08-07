package br.dev.nerdlab.lunor.application.usecases;

import java.util.UUID;

import br.dev.nerdlab.lunor.application.ports.in.CompleteReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.out.ReminderRepositoryPort;
import br.dev.nerdlab.lunor.domain.DomainException;
import br.dev.nerdlab.lunor.domain.Reminder;

public class CompleteReminderService implements CompleteReminderUseCase {

    private final ReminderRepositoryPort reminderRepositoryPort;

    public CompleteReminderService(ReminderRepositoryPort reminderRepositoryPort) {
        this.reminderRepositoryPort = reminderRepositoryPort;
    }

    @Override
    public void execute(UUID id) {

        Reminder reminder = reminderRepositoryPort.findById(id).orElseThrow(
            ()-> new DomainException("Reminder not found with id: " + id));

        reminder.complete();

        reminderRepositoryPort.save(reminder);

    }


}