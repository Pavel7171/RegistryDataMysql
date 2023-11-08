CREATE TABLE IF NOT EXISTS bases(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    base_name VARCHAR(100) ,
    base_owner VARCHAR(100) ,
    created_date DATETIME ,
    type VARCHAR(50) ,
    size BIGINT
    );