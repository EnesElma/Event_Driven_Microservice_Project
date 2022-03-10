create keyspace maildb
    with replication = {'class': 'SimpleStrategy','replication_factor': 1};

use maildb;

CREATE TABLE mail(
                     id UUID PRIMARY KEY,
                     user_id bigint,
                     user_email text,
                     mail_text text
);