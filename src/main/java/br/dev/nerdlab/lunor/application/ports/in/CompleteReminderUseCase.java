package br.dev.nerdlab.lunor.application.ports.in;

import java.util.UUID;

public interface CompleteReminderUseCase {
    void execute(UUID id);
}
