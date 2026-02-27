INSERT INTO Users (username, email)
VALUES
('alex', 'alex@email.com'),
('brown', 'brown@email.com');

INSERT INTO Portfolios (user_id, name)
VALUES
(1, 'Long Term Portfolio'),
(1, 'Crypto Swing'),
(2, 'Tech Stocks');

INSERT INTO Assets (symbol, name, asset_type)
VALUES
('BTC', 'Bitcoin', 'CRYPTO'),
('ETH', 'Ethereum', 'CRYPTO'),
('AAPL', 'Apple Inc.', 'STOCK'),
('TSLA', 'Tesla Inc.', 'STOCK');

INSERT INTO Trades
(portfolio_id, asset_id, trade_type, quantity, price, trade_date)
VALUES
-- Alex Long Term
(1, 1, 'BUY', 0.8, 28000, NOW()),
(1, 3, 'BUY', 10, 150, NOW()),

-- Alex Crypto Swing
(2, 1, 'BUY', 0.2, 32000, NOW()),
(2, 1, 'SELL', 0.1, 35000, NOW()),
(2, 2, 'BUY', 5, 1800, NOW()),

-- Brown Tech
(3, 4, 'BUY', 7, 220, NOW()),
(3, 3, 'BUY', 5, 155, NOW());


