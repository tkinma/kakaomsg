package bookmarket;

import bookmarket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class KakaomsgViewHandler {


    @Autowired
    private KakaomsgRepository kakaomsgRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSentMessage_then_CREATE_1 (@Payload SentMessage sentMessage) {
        try {
            if (sentMessage.isMe()) {
                // view 객체 생성
                Kakaomsg kakaomsg = new Kakaomsg();
                // view 객체에 이벤트의 Value 를 set 함
                kakaomsg.setOrderId(sentMessage.getOrderId());
                kakaomsg.setCustomerId(sentMessage.getCustomerId());
                kakaomsg.setStatus(sentMessage.getStatus());
                kakaomsg.setMessage(sentMessage.getMessage());
                // view 레파지 토리에 save
                kakaomsgRepository.save(kakaomsg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}