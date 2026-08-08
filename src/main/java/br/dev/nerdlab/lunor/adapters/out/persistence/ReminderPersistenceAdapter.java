package br.dev.nerdlab.lunor.adapters.out.persistence;

import br.dev.nerdlab.lunor.application.ports.out.ReminderRepositoryPort;
import br.dev.nerdlab.lunor.domain.DomainException;
import br.dev.nerdlab.lunor.domain.Reminder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ReminderPersistenceAdapter implements ReminderRepositoryPort {
    private final SpringDataReminderRepository repository;

    public ReminderPersistenceAdapter(SpringDataReminderRepository repository) {
        this.repository = repository;
    }


    @Override
    public Reminder save(Reminder reminder) {
        ReminderJpaEntity jpaEntity = ReminderMapper.toJpaEntity(reminder);
        ReminderJpaEntity savedEntity = repository.save(jpaEntity);
        return ReminderMapper.toDomainEntity(savedEntity);
    }

    @Override
    public List<Reminder> findAll() {
        return repository.findAll().stream()
                .map(ReminderMapper::toDomainEntity)
                .toList();
    }

    @Override
    public Optional<Reminder> findById(UUID id) {
        return repository.findById(id).map(ReminderMapper::toDomainEntity);
    }
}
