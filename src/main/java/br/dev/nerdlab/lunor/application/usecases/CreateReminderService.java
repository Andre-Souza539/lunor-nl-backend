package br.dev.nerdlab.lunor.application.usecases;

import br.dev.nerdlab.lunor.application.ports.in.CreateReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.out.ReminderRepositoryPort;
import br.dev.nerdlab.lunor.domain.Reminder;

public class CreateReminderService implements CreateReminderUseCase {

    private final ReminderRepositoryPort reminderRepositoryPort;

    //Injeção via Construtor sem usar (@Autowired) Abordagem purista
    public CreateReminderService(ReminderRepositoryPort repositoryPort) {
        this.reminderRepositoryPort = repositoryPort;
    }

    @Override
    public Reminder execute(Command command) {
       
        // 1. o Caso de uso da instancia do dominio
        Reminder reminder = new Reminder(command.title(), command.dueDate());
        
        // 2. Persistir o Reminder
        return reminderRepositoryPort.save(reminder);

    }

}
