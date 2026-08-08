package br.dev.nerdlab.lunor.configuration;

import br.dev.nerdlab.lunor.application.ports.in.CompleteReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.in.CreateReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.in.ListReminderUseCase;
import br.dev.nerdlab.lunor.application.ports.out.ReminderRepositoryPort;
import br.dev.nerdlab.lunor.application.usecases.CompleteReminderService;
import br.dev.nerdlab.lunor.application.usecases.CreateReminderService;
import br.dev.nerdlab.lunor.application.usecases.ListReminderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReminderConfiguration {

    @Bean
    public CreateReminderUseCase createReminderUseCase(ReminderRepositoryPort repositoryPort){
        return new CreateReminderService(repositoryPort);
    }

    @Bean
    public CompleteReminderUseCase completeReminderUseCase(ReminderRepositoryPort repositoryPort){
        return new CompleteReminderService(repositoryPort);
    }

    @Bean
    public ListReminderUseCase listReminderUseCase(ReminderRepositoryPort repositoryPort){
        return new ListReminderService(repositoryPort);
    }

}
