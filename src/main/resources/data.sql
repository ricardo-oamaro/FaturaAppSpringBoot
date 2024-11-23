CREATE TABLE invoices(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    invoice_date DATE NOT NULL,
    invoice_description VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    insert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE customers(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO invoices(invoice_date, invoice_description, amount) VALUES('2024-11-01', 'Invoice 1', 100.00);
INSERT INTO invoices(invoice_date, invoice_description, amount) VALUES('2024-11-05', 'Invoice 1', 100.00);
INSERT INTO invoices(invoice_date, invoice_description, amount) VALUES('2024-11-07', 'Invoice 1', 100.00);

INSERT INTO customers(name) VALUES('Customer 1');
INSERT INTO customers(name) VALUES('Customer 2');
INSERT INTO customers(name) VALUES('Customer 3');