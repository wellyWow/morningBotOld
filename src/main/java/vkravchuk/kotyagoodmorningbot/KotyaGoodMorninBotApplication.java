package vkravchuk.kotyagoodmorningbot;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@EnableScheduling
@SpringBootApplication
public class KotyaGoodMorninBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(KotyaGoodMorninBotApplication.class, args);

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }

}
