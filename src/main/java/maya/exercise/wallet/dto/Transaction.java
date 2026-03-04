package maya.exercise.wallet.dto;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;


@Data
@Entity
public class Transaction {
    Integer transactionId;
    Date transactionDate;
    Float transactionAmount;
    String transactionDescription;
}
