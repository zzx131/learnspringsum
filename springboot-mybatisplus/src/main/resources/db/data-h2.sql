DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');


INSERT INTO `p_sys_lic`
(`id`,`public_store_pwd`,`private_store_pwd`,
 `issued_time`, `expiry_time`,`consumer_type`,
 `product_code`,`model_code`,`authorizer`,`auth_number`,
 `userd_company`, `userd_hardware`,`create_time`,
 `modified_time`,`is_deleted`,`remarks`)
VALUES ('1','tips@Public123','tips@Public123',
        '2020-03-12 00:00:00','2020-03-12 00:00:00',
        'user','12', '23',
        'zhangzx', '1','huhua',
        '11', '2020-03-12 00:00:00', '2020-03-12 00:00:00',
        '0','hhhh');