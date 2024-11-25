CREATE TABLE customers(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL
);

CREATE TABLE cards(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    card_name VARCHAR(255) NOT NULL
);

CREATE TABLE invoices(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    invoice_date DATE,
    invoice_description VARCHAR(255),
    amount DECIMAL(10, 2),
    total_amount DECIMAL(10, 2),
    insert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    customer_id BIGINT NOT NULL,
    card_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (card_id) REFERENCES cards(id)
);


INSERT INTO customers(customer_name) VALUES('Customer 1');
INSERT INTO customers(customer_name) VALUES('Customer 2');
INSERT INTO customers(customer_name) VALUES('Customer 3');


INSERT INTO cards(card_name) VALUES('Card 1');
INSERT INTO cards(card_name) VALUES('Card 2');
INSERT INTO cards(card_name) VALUES('Card 3');

INSERT INTO invoices(invoice_date, invoice_description, amount, customer_id, card_id) VALUES('2024-11-01', 'Invoice 1', 100.00, 1, 1);
INSERT INTO invoices(invoice_date, invoice_description, amount, customer_id, card_id) VALUES('2024-11-05', 'Invoice 1', 150.00, 2, 2);
INSERT INTO invoices(invoice_date, invoice_description, amount, customer_id, card_id) VALUES('2024-11-07', 'Invoice 1', 200.00, 3, 3);
