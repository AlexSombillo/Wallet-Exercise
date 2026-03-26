

CREATE TABLE transaction (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    amount FLOAT(50),
    recipient_id INTEGER,
    sender_id INTEGER,
    status VARCHAR(255),
    timestamp timestamp(6)
);

CREATE TABLE user_account (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    balance FLOAT(50),
    external_id VARCHAR(255),
    name VARCHAR(255)
);

INSERT INTO user_account (external_id, name, balance) VALUES ('alex-123', 'Alexander', 1000.00);
INSERT INTO user_account (external_id, name, balance) VALUES ('maria-456', 'Maria', 500.00);
INSERT INTO user_account (external_id, name, balance) VALUES ('john-789', 'John', 750.00);


INSERT INTO transaction (sender_id, recipient_id, amount, timestamp, status)
VALUES (1, 2, 200.00, CURRENT_TIMESTAMP, 'SUCCESS');

INSERT INTO transaction (sender_id, recipient_id, amount, timestamp, status)
VALUES (2, 3, 100.00, CURRENT_TIMESTAMP, 'SUCCESS');