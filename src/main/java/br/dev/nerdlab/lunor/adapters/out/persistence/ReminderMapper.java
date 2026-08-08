package br.dev.nerdlab.lunor.adapters.out.persistence;

import br.dev.nerdlab.lunor.domain.Reminder;

public class ReminderMapper {

    public static ReminderJpaEntity toJpaEntity(Reminder reminder){
        return new ReminderJpaEntity(
                reminder.getId(),
                reminder.getTitle(),
                reminder.getDueDate(),
                reminder.isCompleted()
        );
    }

    public static Reminder toDomainEntity(ReminderJpaEntity jpaEntity){
        return new Reminder(
                jpaEntity.getId(),
                jpaEntity.getTitle(),
                jpaEntity.getDueDate(),
                jpaEntity.isCompleted()
        );
    }

}
