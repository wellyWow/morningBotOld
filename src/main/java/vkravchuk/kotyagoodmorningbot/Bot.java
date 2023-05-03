package vkravchuk.kotyagoodmorningbot;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private static final Set<Long> users = new HashSet<>();


    public Bot() {
        super("5991450615:AAE8qZsGdavDpGU6t44HEx2atWcjK1QTv-Y");
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().isCommand()) {
            switch (update.getMessage().getText()) {
                case "/start" -> users.add(update.getMessage().getChatId());
                case "/now" -> sendMorning(update.getMessage().getChatId());
            }
        }
    }

    public void sendMorning() {
        users.forEach(this::sendMorning);
    }

    private void sendMorning(Long chatId) {
        try {
            execute(SendMessage.builder()
                    .chatId(chatId)
                    .text("Morning")
                    .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "KotyaGoodMorningBot";
    }
}
