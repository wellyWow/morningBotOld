package vkravchuk.kotyagoodmorningbot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MorningService {

    private final Bot bot;

    public MorningService(Bot bot) {
        this.bot = bot;
    }

    public void sendMorning() {
        Bot.users.forEach(chatId -> {
            try {
                bot.execute(SendMessage.builder()
                        .chatId(chatId)
                        .text("Morning")
                        .build());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });

    }
}
