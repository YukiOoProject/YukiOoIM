package ink.wanderer.yukiooim.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    @Column(name = "sender")
    private Long senderUid;
    @Column(name = "receiver")
    private Long receiverUid;
    @Column(name = "timestamp")
    private Date timestamp;

    public Message() {
    }

    public Message(Long mid, Long senderUid, Long receiverUid) {
        this.mid = mid;
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
        this.timestamp = new Date(System.currentTimeMillis());
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(Long senderUid) {
        this.senderUid = senderUid;
    }

    public Long getReceiverUid() {
        return receiverUid;
    }

    public void setReceiverUid(Long receiverUid) {
        this.receiverUid = receiverUid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
