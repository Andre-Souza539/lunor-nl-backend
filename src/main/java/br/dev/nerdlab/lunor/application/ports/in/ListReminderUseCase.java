package br.dev.nerdlab.lunor.application.ports.in;

import java.util.List;
import br.dev.nerdlab.lunor.domain.Reminder;

public interface ListReminderUseCase {
    List<Reminder> execute();
}
