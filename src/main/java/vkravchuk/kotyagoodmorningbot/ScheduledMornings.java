package vkravchuk.kotyagoodmorningbot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMornings {

    private final Bot bot;

    public ScheduledMornings(Bot bot) {
        this.bot = bot;
    }

    @Scheduled(fixedDelay = 10000)
    public void schedule() {
        bot.sendMorning();
    }
}
