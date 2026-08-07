package br.dev.nerdlab.lunor.application.ports.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.dev.nerdlab.lunor.domain.Reminder;

public interface ReminderRepositoryPort {
    
    Reminder save(Reminder reminder);
    List<Reminder> findAll();
    Optional<Reminder> findById(UUID id);

}
