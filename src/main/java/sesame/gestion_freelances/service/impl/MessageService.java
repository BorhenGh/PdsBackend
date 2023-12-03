package sesame.gestion_freelances.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import sesame.gestion_freelances.models.Message;
import sesame.gestion_freelances.models.User;
import sesame.gestion_freelances.repository.MessageDao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageDao messageRepository;

    public void saveMessage(Message message) {
        System.out.println("Enregistrement du message avec chatId : " + message.getChatId());
        messageRepository.save(message);
    }


    public List<Message> getChatMessagesBetweenUsers(int userId1, int userId2) {
        String chatId = generateChatId(userId1, userId2);
        System.out.println("Récupération des messages pour chatId : " + chatId);
        List<Message> messages = messageRepository.findByChatIdOrderByDateSent(chatId);
        System.out.println("Nombre de messages récupérés : " + messages.size());
        return messages;
    }


    public void sendMessageToUser(User user, Message message) {
        String userDestination = "/user/" + user.getId() + "/queue/messages";
        messagingTemplate.convertAndSend(userDestination, message);
    }

    public String generateChatId(int userId1, int userId2) {
        List<Integer> sortedUserIds = Arrays.asList(userId1, userId2);
        sortedUserIds.sort(Comparator.naturalOrder());
        return String.format("chat_%d_%d", sortedUserIds.get(0), sortedUserIds.get(1));
    }

}
