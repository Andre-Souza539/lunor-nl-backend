package br.dev.nerdlab.lunor.application.usecases;

import java.util.List;

import br.dev.nerdlab.lunor.application.ports.in.ListReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.out.ReminderRepositoryPort;
import br.dev.nerdlab.lunor.domain.Reminder;

public class ListReminderService implements ListReminderUseCase {

    private final ReminderRepositoryPort reminderRepositoryPort;

    public ListReminderService(ReminderRepositoryPort reminderRepositoryPort) {
        this.reminderRepositoryPort = reminderRepositoryPort;
    }

    @Override
    public List<Reminder> execute() {
        return reminderRepositoryPort.findAll();
    }

}
