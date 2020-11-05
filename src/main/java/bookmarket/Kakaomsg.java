package bookmarket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Kakaomsg_table")
public class Kakaomsg {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private Long customerId;
        private String status;
        private String message;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

}
