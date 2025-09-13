DROP TABLE products;
CREATE TABLE categories(
    category_id UUID PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE
);
CREATE TABLE products(
    product_id UUID PRIMARY KEY,
    category_id UUID NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    description TEXT,
    CONSTRAINT fk_category FOREIGN KEY (category_id)
        REFERENCES categories(category_id)
);
CREATE TABLE product_prices(
    price_id UUID PRIMARY KEY,
    product_id UUID NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    cost_price DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    CONSTRAINT fk_product_price FOREIGN KEY (product_id)
        REFERENCES products(product_id)
)
